package com.example.newsappjava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileWriter;
import java.io.IOException;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.OpenWrapSDK;
import com.pubmatic.sdk.common.models.POBApplicationInfo;
import com.pubmatic.sdk.openwrap.banner.POBBannerView;
import com.pubmatic.sdk.openwrap.interstitial.POBInterstitial;
// Import Java Packages.
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements NewsItemClicked{

    private RecyclerView recyclerView;
    private NewsListAdapter mAdapter;
    private POBBannerView bannerView;
    private static final String OPENWRAP_AD_UNIT_ID = "OpenWrapBannerAdUnit";
    private static final String PUB_ID = "156276";
    private static final int PROFILE_ID = 1165;
    private static final String OPENWRAP_AD_UNIT_ONE = "OpenWrapInterstitialAdUnit";
    private POBInterstitial interstitial;
    private Button loadAd,showAd;
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new NewsListAdapter(this);
        //buttons
        loadAd=(Button) findViewById(R.id.loadAd);
        showAd=(Button)findViewById(R.id.showAd);
        fetchData();
        recyclerView.setAdapter(mAdapter);
        //         A valid Play Store Url of an Android application is required.
        POBApplicationInfo appInfo = new POBApplicationInfo();
        try {
            appInfo.setStoreURL(new URL("https://play.google.com/store/apps/details?id=com.example.android&hl=en"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // This app information is a global configuration & you
        // Need not set this for every ad request(of any ad type)
        OpenWrapSDK.setApplicationInfo(appInfo);
        bannerView=(POBBannerView) findViewById(R.id.banner);
        bannerView.init(PUB_ID,
                PROFILE_ID,
                OPENWRAP_AD_UNIT_ID, POBAdSize.BANNER_SIZE_320x50);
        bannerView.setListener(new POBBannerViewListener());
        bannerView.loadAd();

        interstitial = new POBInterstitial(this, PUB_ID,
                PROFILE_ID,
                OPENWRAP_AD_UNIT_ONE);
        loadAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interstitial.loadAd();
                showAd.setEnabled(true);
            }
        });
        showAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd();
            }
        });
    }
    /**
     * To show interstitial ad call this method
     **/
    private void showInterstitialAd() {
        // check if the interstitial is ready
        if (null != interstitial) {
            // Call show on interstitial
            interstitial.show();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Destroy banner before destroying activity
        if (null != bannerView) {
            bannerView.destroy();
        }
    }
    /**
     * Restart function to fetch the data on restart
     * @return nothing
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        fetchData();
    }

    /**
     * fetchData function create the json object to get the response and call the update news function of the NewslistAdapter class.
     * Add the JsonObjectRequest to the request queue.
     */
    private void fetchData()
    {

        String url="https://stagingams.pubmatic.com:8443/sdk/Sushant/news.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    /**
                     * Listener method work after receiving the jsonObject response.
                     * @param response JSONObject contains the JSONArray and JSON elements.
                     */
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray newsJsonArray=response.getJSONArray("articles");
                            ArrayList<News> newsArray=new ArrayList<News>();
                            for (int i=0;i<newsJsonArray.length();i++)
                            {
                                //fetching the jsonboject from the jsonarray
                                JSONObject newsJsonObject=newsJsonArray.getJSONObject(i);

                                //creating object of news classes by parametric constructor
                                News news=new News(newsJsonObject.getString("title"),
                                        newsJsonObject.getString("author"),
                                        newsJsonObject.getString("url"),
                                        newsJsonObject.getString("urlToImage"));

                                //adding the created object into the array of objects
                                newsArray.add(news);
                            }
                            mAdapter.updateNews(newsArray);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(error.toString(),"Failed to recevie response from provided API.");
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    /**
     * onItemClicked is an of NewsItemClicked Interface.
     * which open links in the custom chrome tab.
     * @param item View of Recycler View holder.
     */
    @Override
    public void onItemClicked(News item) {
        if(item==null) {
            Log.d("Error","Object is null");
        }
        else
        {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse(item.url));
        }
    }
    class POBBannerViewListener extends POBBannerView.POBBannerViewListener {
        private final String TAG = "POBBannerViewListener";

        // Callback method Notifies that an ad has been successfully loaded and rendered.
        @Override
        public void onAdReceived(@NonNull POBBannerView view) {
            Log.d(TAG, "Ad Received");
        }

        // Callback method Notifies an error encountered while loading or rendering an ad.
        @Override
        public void onAdFailed(@NonNull POBBannerView view, @NonNull POBError error) {
            Log.e(TAG, error.toString());
        }

        // Callback method Notifies that the banner ad view will launch a dialog on top of the current view
        @Override
        public void onAdOpened(@NonNull POBBannerView view) {
            Log.d(TAG, "Ad Opened");
        }

        // Callback method Notifies that the banner ad view has dismissed the modal on top of the current view
        @Override
        public void onAdClosed(@NonNull POBBannerView view) {
            Log.d(TAG, "Ad Closed");
        }

        @Override
        public void onAppLeaving(@NonNull POBBannerView view) {
            // Implement your custom logic
            Log.d(TAG, "Banner : App Leaving");
        }

    }
}