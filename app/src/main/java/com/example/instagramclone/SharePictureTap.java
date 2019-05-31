package com.example.instagramclone;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ManifestInfo;

public class SharePictureTap extends Fragment implements View.OnClickListener {

private ImageView imageView;
private EditText editText;
private Button button;
   private Bitmap bitmap;
    public SharePictureTap() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_share_picture_tap, container, false);
        imageView=view.findViewById(R.id.post_image);
        editText=view.findViewById(R.id.picture_describtion);
        button=view.findViewById(R.id.share_image_button);

        imageView.setOnClickListener(SharePictureTap.this);
        button.setOnClickListener(SharePictureTap.this);




        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.post_image:
                getChoosenImg();


                break;


            case R.id.share_image_button:
                if (bitmap!=null){


                }


                break;
        }
    }

    private void getChoosenImg() {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,2000);

        Toast.makeText(getContext(),"working",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1000){
            if (grantResults.length>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                getChoosenImg();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {





        if (requestCode==2000){
            if (resultCode== Activity.RESULT_OK){
                try {
                    Uri selectedImg=data.getData();
                    String[]filePath={MediaStore.Images.Media.DATA};
                    Cursor cursor=getActivity().getContentResolver().query(selectedImg,filePath,null,null,null);
                    cursor.moveToFirst();
                    int columnIndex=cursor.getColumnIndex(filePath[0]);
                    String picturePath=cursor.getString(columnIndex);
                    cursor.close();
                     bitmap= BitmapFactory.decodeFile(picturePath);
                    imageView.setImageBitmap(bitmap);



                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        }
    }
}
