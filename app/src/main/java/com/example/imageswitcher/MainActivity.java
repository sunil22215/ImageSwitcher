package com.example.imageswitcher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    int imageSwitcherImages[] =
            {R.drawable.burger,
                    R.drawable.burger3,
                    R.drawable.burger4,
                    R.drawable.burger5,
                    R.drawable.burger2};
    private Button button;
    private Button button1;
    private int switcherImageLength = imageSwitcherImages.length;
    private int counter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindLayoutView();
        setUpViewWithLayout();
    }

    public void bindLayoutView() {
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
    }

    public void setUpViewWithLayout() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if (counter == switcherImageLength) {
                    counter = 0;
                    imageSwitcher.setImageResource(imageSwitcherImages[counter]);
                } else {
                    imageSwitcher.setImageResource(imageSwitcherImages[counter]);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                if(counter==switcherImageLength){
                    counter=4;
                    imageSwitcher.setImageResource(imageSwitcherImages[counter]);
                }
                else{
                    imageSwitcher.setImageResource(imageSwitcherImages[counter]);
                }
            }
        });
    }


}