package holy.shit.instragram.ui.profile;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import holy.shit.instragram.R;

public class ProfileFragment extends Fragment {

    private static final String TAG = "ProfileFragment";

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(view != null) return  view;
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

}
