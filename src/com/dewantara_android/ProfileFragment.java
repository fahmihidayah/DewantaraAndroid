package com.dewantara_android;

import com.dewantara_android.R;
import com.models.DataSingleton;

import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

	private View rootView;
	private TextView textViewProfile;
	private Button buttonEditProfile;

	private void initialComponent() {
		buttonEditProfile = (Button) rootView
				.findViewById(R.id.buttonEditProfile);
		textViewProfile = (TextView) rootView
				.findViewById(R.id.textViewProfile);

		buttonEditProfile.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				getActivity().startActivity(
						new Intent(getActivity(), EditProfileActivity.class));
			}

		});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.profile_fragment, null);
		initialComponent();
		return rootView;
	}

	@Override
	public void onResume() {
		if (DataSingleton.getInstance().getGuru() != null) {
			textViewProfile.setText(DataSingleton.getInstance().getGuru()
					.toString());
		}
		super.onResume();
	}

}
