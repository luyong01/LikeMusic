package com.ranze.maincomponent;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ranze.basiclib.util.LogUtil;
import com.ranze.basiclib.util.schedulers.SchedulerProvider;
import com.ranze.componentservice.app.BaseCommonActivity;
import com.ranze.maincomponent.data.MainRepository;
import com.ranze.maincomponent.router.path.PathConstants;

/**
 * Created by ranze on 2018/2/23.
 */
@Route(path = PathConstants.VIEW_LOGIN)
public class LoginActivity extends BaseCommonActivity {
    private EditText mEditPhone;
    private EditText mEditPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincomponent_activity_login);

        mEditPhone = findViewById(R.id.edit_phone);
        mEditPassword = findViewById(R.id.edit_password);
        mBtnLogin = findViewById(R.id.btn_login);

        showSoftInputFromWindow(this, mEditPhone);

        mBtnLogin.setOnClickListener(v -> {
            String phone = mEditPhone.getText().toString();
            String password = mEditPassword.getText().toString();
            MainRepository.getInstance().login(phone, password)
                    .subscribeOn(SchedulerProvider.getInstance().io())
                    .observeOn(SchedulerProvider.getInstance().ui())
                    .subscribe(success -> {
                        if (success) {
                            ARouter.getInstance().build(PathConstants.VIEW_MAIN).navigation();
                        } else {
                            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }, throwable -> LogUtil.d("login, onError: " + throwable));
        });

    }

    public void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
}
