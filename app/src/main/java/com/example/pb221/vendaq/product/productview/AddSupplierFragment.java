package com.example.pb221.vendaq.product.productview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.main.BaseFragment;
import com.example.pb221.vendaq.main.WebCallFragment;

import org.json.JSONObject;

import static com.example.pb221.vendaq.main.utils.Utils.addSupplier;

/**
 * Created by Manifest on 12/31/2017.
 */


public class AddSupplierFragment extends BaseFragment {

    EditText supplierName;
    EditText markup;
    EditText description;
    EditText firstName;
    EditText lastName;
    EditText company;
    EditText email;
    EditText phone;
    EditText mobile;
    EditText fax;
    EditText website;
    EditText twitter;
    EditText street1;
    EditText street2;
    EditText suburb;
    EditText postcode;
    EditText state;
    EditText country;
    Button cancelBtn;
    Button saveBtn;
    String result ="";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_add_supplier, null);
        getActivity().setTitle("Add Supplier");
        supplierName = (EditText) v.findViewById(R.id.supplierNameEditText);
        markup = (EditText) v.findViewById(R.id.markupEditText);
        description = (EditText) v.findViewById(R.id.descriptionEditText);
        firstName = (EditText) v.findViewById(R.id.firstNameEditText);
        lastName = (EditText) v.findViewById(R.id.lastNameEditText);
        company = (EditText) v.findViewById(R.id.companyEditText);
        email = (EditText) v.findViewById(R.id.emailEditText);
        phone = (EditText) v.findViewById(R.id.phoneEditText);
        mobile = (EditText) v.findViewById(R.id.mobileEditText);
        fax = (EditText) v.findViewById(R.id.faxText);
        website = (EditText) v.findViewById(R.id.websiteEditText);
        twitter = (EditText) v.findViewById(R.id.twitterEditText);
        street1 = (EditText) v.findViewById(R.id.street1EditText);
        street2 = (EditText) v.findViewById(R.id.street2EditText);
        suburb = (EditText) v.findViewById(R.id.suburbEditText);
        postcode = (EditText) v.findViewById(R.id.postCodeEditText);
        state = (EditText) v.findViewById(R.id.stateEditText);
        country = (EditText) v.findViewById(R.id.countryEditText);
        cancelBtn = (Button) v.findViewById(R.id.cancelBtn);
        saveBtn = (Button) v.findViewById(R.id.saveBtn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelBtnClick();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBtnClick();
            }
        });
        return v;
    }


    private void cancelBtnClick()
    {
        supplierName.setText("");
        markup.setText("");
        description.setText("");
        firstName.setText("");
        lastName.setText("");
        company.setText("");
        email.setText("");
        phone.setText("");
        mobile.setText("");
        fax.setText("");
        website.setText("");
        twitter.setText("");
        street1.setText("");
        street2.setText("");
        suburb.setText("");
        postcode.setText("");
        state.setText("");
        country.setText("");
    }
    private void saveBtnClick()
    {
        if (supplierName.getText().toString() == null || supplierName.getText().toString().isEmpty())
        {
            showAlert("Please enter supplier name","Suppier Name required");
        }
        else
        {
            addSupplier();
        }
    }

    private void addSupplier()
    {
        final JSONObject job = new JSONObject();

        try {
            job.put(getResources().getString(R.string.str_key_supliername), supplierName.getText().toString());
            job.put(getResources().getString(R.string.str_key_markup), markup.getText().toString());
            job.put(getResources().getString(R.string.str_key_description), description.getText().toString());
            job.put(getResources().getString(R.string.str_key_firstname), firstName.getText().toString());
            job.put(getResources().getString(R.string.str_key_lastname), lastName.getText().toString());
            job.put(getResources().getString(R.string.str_key_company), company.getText().toString());
            job.put(getResources().getString(R.string.str_key_email), email.getText().toString());
            job.put(getResources().getString(R.string.str_key_phone), phone.getText().toString());
            job.put(getResources().getString(R.string.str_key_mobile), mobile.getText().toString());
            job.put(getResources().getString(R.string.str_key_fax), fax.getText().toString());
            job.put(getResources().getString(R.string.str_key_website), website.getText().toString());
            job.put(getResources().getString(R.string.str_key_twitter), twitter.getText().toString());
            job.put(getResources().getString(R.string.str_key_street1), street1.getText().toString());
            job.put(getResources().getString(R.string.str_key_street2), street2.getText().toString());
            job.put(getResources().getString(R.string.str_key_suburb), suburb.getText().toString());
            job.put(getResources().getString(R.string.str_key_postcode), postcode.getText().toString());
            job.put(getResources().getString(R.string.str_key_state), state.getText().toString());
            job.put(getResources().getString(R.string.str_key_country), country.getText().toString());
            job.put(getResources().getString(R.string.str_key_ispostaladdress), "true");
            job.put(getResources().getString(R.string.str_key_userId), "1");




            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(addSupplier, job.toString());
                Log.e("**result IN SU*", result + "");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        getFragmentManager().popBackStack();
    }
}
