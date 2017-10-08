package holy.shit.instragram.network;

import android.util.Log;

import org.reactivestreams.Subscription;

import holy.shit.instragram.models.NetworkResponse;
import holy.shit.instragram.models.UserProfile;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NetworkService {

    private static final String TAG = "NetworkService";

    private final NetworkInterface networkInterface;

    public NetworkService(NetworkInterface networkInterface){
        this.networkInterface = networkInterface;
    }

    public void getUserProfile(final ResponseCallback callback){
        networkInterface.getUserProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NetworkResponse<UserProfile>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull NetworkResponse<UserProfile> userProfileNetworkResponse) {
                        Log.d(TAG, "onNext: get user profile success.");
                        callback.onSuccess(userProfileNetworkResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: fail to get user profile " + e.getMessage());
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface ResponseCallback{
        void onSuccess(NetworkResponse response);
        void onError(String message);
    }
}
