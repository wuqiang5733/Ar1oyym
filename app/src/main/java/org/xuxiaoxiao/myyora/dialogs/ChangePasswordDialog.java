package org.xuxiaoxiao.myyora.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xuxiaoxiao.myyora.R;


public class ChangePasswordDialog extends BaseDialogFragment implements View.OnClickListener {
    private EditText _currentPassword;
    private EditText _newPassword;
    private EditText _confirmNewPassword;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_change_password, null, false);

        _currentPassword = (EditText) dialogView.findViewById(R.id.dialog_change_password_currentPassword);
        _newPassword = (EditText) dialogView.findViewById(R.id.dialog_change_password_newPassword);
        _confirmNewPassword = (EditText) dialogView.findViewById(R.id.dialog_change_password_confirmNewPassword);

        if (!application.getAuth().getUser().isHasPassword())
            // 可能用 Google 登陆就不会有密码
            _currentPassword.setVisibility(View.GONE);

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(dialogView)
                // If an OnClickListener is passed as second argument, no matter what we do
                // when the button is pressed the dialog will close.
                .setPositiveButton(getActivity().getString(R.string.ChangePasswordDialogUpdate), null)
                .setNegativeButton(getActivity().getString(R.string.ChangePasswordDialogCancel), null)
                .setTitle(getActivity().getString(R.string.ChangePasswordDialogChangePassword))
                .show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(this);

        return dialog;
    }

    @Override
    public void onClick(View view) {
        // TODO Send new password to server
        Toast.makeText(getActivity(), R.string.ChangePasswordDialogPasswordUpdated, Toast.LENGTH_SHORT).show();
        dismiss();
    }
}
