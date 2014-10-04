package com.example.remotecontrol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;

public class RemoteControlActivity extends SingleFragmentActtivity {

	@Override
	protected Fragment createFragment() {
		return new RemoteControlFragment();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
	}
}
