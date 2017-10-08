package holy.shit.instragram.network;

import holy.shit.instragram.models.NetworkResponse;
import holy.shit.instragram.models.UserProfile;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkInterface {

    @GET("api/profile/{id}")
    Observable<NetworkResponse<UserProfile>> getUserProfile();

}
