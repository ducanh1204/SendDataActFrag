package vm.poly.edu.senddataactfrag;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class HomeFragment extends Fragment {

    private EditText edtData;
    private Button btnUpdate;
    private View mView;
    private User user;
    private Bundle bundle;
    private  ISendDataListener iSendDataListener;

    public interface ISendDataListener {
        void sendData(String data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iSendDataListener = (ISendDataListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        bundle = getArguments();

        user = (User) bundle.getSerializable("object");

        initUI();
        return mView;
    }

    private void initUI() {
        edtData = mView.findViewById(R.id.edt_data);

//        edtData.setText(bundle.getString("data"));
        edtData.setText(user.getName());

        btnUpdate = mView.findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToActivity();
            }
        });
    }

    private void sendDataToActivity() {
        String data = edtData.getText().toString().trim();
        if(iSendDataListener!=null){
            iSendDataListener.sendData(data);
        }
    }
}