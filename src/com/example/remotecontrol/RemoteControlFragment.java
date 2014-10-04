package com.example.remotecontrol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class RemoteControlFragment extends Fragment {

	private TextView selectedTextView;
	private TextView workingTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_remote_control, container, false);
		selectedTextView = (TextView) view.findViewById(R.id.fragment_remote_control_selectedTextView);
		workingTextView = (TextView) view.findViewById(R.id.fragment_remote_control_workingTextView);

		View.OnClickListener numberButtonListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				TextView textView = (TextView) v;
				String working = workingTextView.getText().toString();
				String text = textView.getText().toString();
				if (working.equals("0")) {
					workingTextView.setText(text);
				} else {
					workingTextView.setText(working + text);
				}
			}
		};

		TableLayout tableLayout = (TableLayout) view.findViewById(R.id.fragment_remote_control_tableLayout);
		int number = 1;
		for (int i = 2; i < tableLayout.getChildCount() - 1; i++) {
			TableRow tableRow = (TableRow) tableLayout.getChildAt(i);
			for (int j = 0; j < tableRow.getChildCount(); j++) {
				Button button = (Button) tableRow.getChildAt(j);
				button.setText("" + number);
				button.setOnClickListener(numberButtonListener);
				number++;
			}
		}

		TableRow bottomRow = (TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1);

		Button deleteButton = (Button) bottomRow.getChildAt(0);
		deleteButton.setText("Delete");
		deleteButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				workingTextView.setText("0");
			}
		});

		Button zeroButton = (Button) bottomRow.getChildAt(1);
		zeroButton.setText("0");
		zeroButton.setOnClickListener(numberButtonListener);

		Button enterButton = (Button) bottomRow.getChildAt(2);
		enterButton.setText("Enter");
		enterButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				CharSequence working = workingTextView.getText();
				if (working.length() > 0) {
					selectedTextView.setText(working);
				}
			}
		});
		return view;
	}
}
