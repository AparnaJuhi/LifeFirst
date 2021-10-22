package com.example.lifefirst_app.ui;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lifefirst_app.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class aboutus extends Fragment {

    private AboutusViewModel mViewModel;
    private ImageView mImageView;
    public static aboutus newInstance() {
        return new aboutus();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.aboutus_fragment, container, false);
        //first of all we declare root and then return root
        ImageView insta = (ImageView) root.findViewById(R.id.insta);
        insta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/lifefirst_24/"));
                startActivity(intent);
            }
        });
        ImageView facebook = (ImageView) root.findViewById(R.id.fb);
        facebook.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/LifeFirst24"));
                startActivity(intent);
            }
        });
        ImageView twitter = (ImageView) root.findViewById(R.id.twi);
        twitter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/LifeFirst_24"));
                startActivity(intent);
            }
        });

        ImageView linkedin = (ImageView) root.findViewById(R.id.lin);
        linkedin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/life-first-megakit-930500210/"));
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AboutusViewModel.class);
        // TODO: Use the ViewModel
    }

}