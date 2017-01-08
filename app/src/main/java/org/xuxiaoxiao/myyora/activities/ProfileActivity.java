package org.xuxiaoxiao.myyora.activities;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.soundcloud.android.crop.Crop;

import org.xuxiaoxiao.myyora.R;
import org.xuxiaoxiao.myyora.views.MainNavDrawer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends BaseAuthenticatedActivity implements View.OnClickListener {
    private static final int REQUEST_SELECT_IMAGE = 100;
    private ImageView _avatarView;
    private View _avatarProgressFrame;
    private File _tempOutputFile;

    @Override
    protected void onYoraCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Profile");
        setNavDrawer(new MainNavDrawer(this));

        if (!isTablet) { // Video37_22min
            View textFields = findViewById(R.id.activity_profile_textFields);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) textFields.getLayoutParams();
            params.setMargins(0, params.getMarginStart(), 0, 0);//left,top,right,bottom
            params.setMarginStart(0); //Without it the margin start won't be removed!
            params.removeRule(RelativeLayout.END_OF);
            params.addRule(RelativeLayout.BELOW, R.id.activity_profile_changeAvatar);// 放到头像下面
            textFields.setLayoutParams(params);
        }

        _avatarView = (ImageView) findViewById(R.id.activity_profile_avatar);
        _avatarProgressFrame = findViewById(R.id.activity_profile_avatarProgressFrame);
        _tempOutputFile = new File(getExternalCacheDir(), "temp_image.jpg");
        // 点击头像或者头像下面的文字都会生成事件
        _avatarView.setOnClickListener(this);
        findViewById(R.id.activity_profile_changeAvatar).setOnClickListener(this);
        // 没有下面这一句，是不能点击的，它会不停的转
        _avatarProgressFrame.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        // 如果是点击了头像或者是头像下面的文字
        if (viewId == R.id.activity_profile_avatar || viewId == R.id.activity_profile_changeAvatar) {
            changeAvatar();
        }
    }
    private void changeAvatar() {
        // Create a list of explicit intents to start activities which can perform ACTION_IMAGE_CAPTURE
        // ResolveInfo : Information that is returned from resolving an intent against an IntentFilter.
        // This partially corresponds to information collected from the AndroidManifest.xml's <intent> tags.
        /*
        *  这一部分是implicit的请求可以拍照的 Intent
        */
        // 申明一个在本系统上可以拍照的Intent的List
        List<Intent> otherImageCaptureIntents = new ArrayList<>();
        //请求系统上所有可以完成 MediaStore.ACTION_IMAGE_CAPTURE 的 Activity
        List<ResolveInfo> otherImageCaptureActivities = getPackageManager()
                .queryIntentActivities(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 0);
        for (ResolveInfo info : otherImageCaptureActivities) {
            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            captureIntent.setClassName(info.activityInfo.packageName, info.activityInfo.name);
            // 往那里存放 Image
            captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(_tempOutputFile));
            otherImageCaptureIntents.add(captureIntent);
        }
       /*
        *  这一部分是implicit的请求可以 选取图片的 Intent
        */
        // Create a chooser and fill it with activities which can perform ACTION_PICK on images
        Intent selectImageIntent = new Intent(Intent.ACTION_PICK);
        selectImageIntent.setType("image/*");
        Intent chooser = Intent.createChooser(selectImageIntent, getString(R.string.ChooserAvatar).toString());

        // Add ACTION_IMAGE_CAPTURE activities to the chooser list
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, otherImageCaptureIntents.toArray(new Parcelable[otherImageCaptureIntents.size()]));

        // Start chooser
        startActivityForResult(chooser, REQUEST_SELECT_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            _tempOutputFile.delete();
            return;
        }

        Uri tempFileUri = Uri.fromFile(_tempOutputFile);
        if (requestCode == REQUEST_SELECT_IMAGE) {
            Uri outputFileUri;

            if (data != null && (data.getAction() == null || !data.getAction().equals(MediaStore.ACTION_IMAGE_CAPTURE)))
                outputFileUri = data.getData(); // If the user selected an image
            else
                outputFileUri = tempFileUri; // User took a picture

            new Crop(outputFileUri)
                    .asSquare()
                    .output(tempFileUri)
                    .start(this);
        } else if (requestCode == Crop.REQUEST_CROP) {
            // TODO: Send tempFileUri to server as new avatar
            _avatarView.setImageResource(0); // Force ImageView to refresh image despite its Uri not changed
            _avatarView.setImageURI(tempFileUri);
        }
    }
}
