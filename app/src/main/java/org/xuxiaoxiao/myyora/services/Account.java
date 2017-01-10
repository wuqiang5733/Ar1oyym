package org.xuxiaoxiao.myyora.services;

import android.net.Uri;

import org.xuxiaoxiao.myyora.infrastructure.ServiceResponse;

public final class Account {
    //这个类是不能实例化的，这个类是为了 Hold 其它类的，它存在的目的就是组织，
    // final 与 private 就是不让实例化。
    // 在 Java 当中也不允许一个文件当中有多个顶层类，这样做，也是为这个目的。
    private Account(){
    }

    public static class ChangeAvatarRequest {
        public Uri NewAvatarUri;

        public ChangeAvatarRequest(Uri newAvatarUri) {
            NewAvatarUri = newAvatarUri;
        }
    }

    public static class ChangeAvatarResponse extends ServiceResponse {

    }

    public static class UpdateProfileRequest {
        public String DisplayName;
        public String Email;

        public UpdateProfileRequest(String displayName, String email) {
            DisplayName = displayName;
            Email = email;
        }
    }

    public static class UpdateProfileResponse extends ServiceResponse {
    }

    public static class ChangePasswordRequest {
        public String CurrentPassword;
        public String NewPassword;
        public String ConfirmNewPassword;

        public ChangePasswordRequest(String currentPassword, String newPassword, String confirmNewPassword) {
            CurrentPassword = currentPassword;
            NewPassword = newPassword;
            ConfirmNewPassword = confirmNewPassword;
        }
    }

    public static class ChangePasswordResponse extends ServiceResponse {
    }
}
