package org.xuxiaoxiao.myyora.services;


import com.squareup.otto.Subscribe;

import org.xuxiaoxiao.myyora.infrastructure.YoraApplication;

public class InMemoryAccountService extends BaseInMemoryService {

    public InMemoryAccountService(YoraApplication application) {
        super(application);
    }

    @Subscribe
    public void updateProfile(Account.UpdateProfileRequest request) {
        Account.UpdateProfileResponse response = new Account.UpdateProfileResponse();
        if (request.DisplayName.equals("Dariush")) {
            response.setPropertyError("displayName", "You may not be named Dariush!");
        }
        postDelayed(response);
    }

    @Subscribe
    public void updateAvatar(Account.ChangeAvatarRequest request) {
        postDelayed(new Account.ChangeAvatarResponse());
    }

    @Subscribe
    public void changePassword(Account.ChangePasswordRequest request) {
        Account.ChangePasswordResponse response = new Account.ChangePasswordResponse();

        if (!request.NewPassword.equals(request.ConfirmNewPassword))
            response.setPropertyError("confirmNewPassword", "Passwords must match!");

        if (request.NewPassword.length() < 3)
            response.setPropertyError("newPassword", "Passwords must larger than 3 characters!");

        postDelayed(response);
    }
}
