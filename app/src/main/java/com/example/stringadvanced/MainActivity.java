package com.example.stringadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;

import java.util.PrimitiveIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private String url = "http://dratyti.info/znamenitosti/zvyozdy-chi-nastoyashchie-imena-vas-udivyat.html";
    private String str="<p>Что же, впрочем вы и сами можете узнать в этой фотоподборке настоящие имена звёзд, которые скрывают их, выдавая себя под другим именем.</p>\n" +
            "<h3>Тимати — Тимур Юнусов</h3>\n" +
            "<p><img class=\"size-full wp-image-3009 aligncenter\" src=\"http://dratyti.info/wp-content/uploads/2017/06/zvezdi-sdrugimi-imenami-109.png\" alt=\"\" width=\"727\" height=\"1095\" srcset=\"http://dratyti.info/wp-content/uploads/2017/06/zvezdi-sdrugimi-imenami-109.png 727w, http://dratyti.info/wp-content/uploads/2017/06/zvezdi-sdrugimi-imenami-109-199x300.png 199w, http://dratyti.info/wp-content/uploads/2017/06/zvezdi-sdrugimi-imenami-109-680x1024.png 680w\" sizes=\"(max-width: 727px) 100vw, 727px\" /></p>\n" +
            "<h3>Тутта Ларсен — Татьяна Романенко</h3>\n" +
            "<h3><img class=\"size-full wp-image-3008 aligncenter\" src=\"http://dratyti.info/wp-content/uploads/2017/06/zvezdi-sdrugimi-imenami-108.png\" alt=\"\" width=\"727\" height=\"1091\" srcset=\"http://dratyti.info/wp-content/uploads/2017/06/zvezdi-sdrugimi-imenami-108.png 727w, http://dratyti.info/wp-content/uploads/2017/06/zvezdi-sdrugimi-imenami-108-200x300.png 200w, http://dratyti.info/wp-content/uploads/2017/06/zvezdi-sdrugimi-imenami-108-682x1024.png 682w\" sizes=\"(max-width: 727px) 100vw, 727px\" /></h3>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pattern pattern = Pattern.compile("<h3>(?!<)(.*)<\\/h3>");
        Matcher matcher = pattern.matcher(str);

        Pattern pattern1 = Pattern.compile("src=\"(.*?)\"");
        //Matcher matcher1 = pattern1.matcher(str);

        while (matcher.find()){
            Log.i("match",matcher.group(1));
        }

        pattern = Pattern.compile("<h3><img(.*?)\\/>|<p><img(.*?)\\/>");
        matcher=pattern.matcher(str);
        while (matcher.find()){
         Matcher matcher1 = pattern1.matcher(matcher.group());

            while (matcher1.find()){
                Log.i("link_match",matcher1.group(1));
            }

            Log.i("match",matcher.group());
        }

    }
}