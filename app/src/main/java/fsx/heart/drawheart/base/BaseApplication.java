package fsx.heart.drawheart.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author FANG SHIXIAN
 * @date 2020/8/11.
 * description：
 */
public class BaseApplication extends Application {

    private static Context mContext;
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        registerActivityLifecycleCallbacks(lifecycleCallbacks);
        mContext = this.getApplicationContext();
        mApplication = this;
        super.onCreate();
    }

    private ActivityLifecycleCallbacks lifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
//            fixViewMutiClickInShortTime(activity);
        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {

        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {

        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    };
}
