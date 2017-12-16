package com.example.pb221.vendaq.main.view;

import android.app.Fragment;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pb221.vendaq.main.BaseActivity;
import com.example.pb221.vendaq.main.BaseFragment;
import com.example.pb221.vendaq.main.FragmentDataObserver;
import com.example.pb221.vendaq.main.IDataObserver;
import com.example.pb221.vendaq.main.adapter.DrowerOutsidePOJO;
import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.sell.sellview.FragmentSalesScreen;
import com.example.pb221.vendaq.product.productmodel.BrandPOJO;
import com.example.pb221.vendaq.product.productview.BrandFragment;
import com.example.pb221.vendaq.product.productview.PriceBookFragment;
import com.example.pb221.vendaq.product.productview.ProductListFragment;
import com.example.pb221.vendaq.product.productview.ProductTagsFragment;
import com.example.pb221.vendaq.product.productview.ProductTypeFragment;
import com.example.pb221.vendaq.product.productview.StockControlFragment;
import com.example.pb221.vendaq.product.productview.SupplierFragment;
import com.example.pb221.vendaq.sell.selladapter.CashManagementAdapter;
import com.example.pb221.vendaq.sell.sellmodel.CashManagementPOJO;
import com.example.pb221.vendaq.sell.sellview.CashManagementFragment;
import com.example.pb221.vendaq.sell.sellview.CloseRegisterFragment;
import com.example.pb221.vendaq.sell.sellview.DashBoardFragment;
import com.example.pb221.vendaq.sell.sellview.SaleHistoryFragment;
import com.example.pb221.vendaq.sell.sellview.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    FragmentDataObserver fragmentDataObserver;
    private MenuItem mSearchItem;
    private int flag;
    private SearchView sv;
    private DrawerLayout drawer;
    ActionBarDrawerToggle mDrawerToggle;
    private FrameLayout frameLayoutcontainer;
    private ListView leftList;
    private ListView rightList;
    private String[] leftListStrings;


    public DrowerOutsidePOJO drawerListdapter;
    public CashManagementAdapter cashListAdapter;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public Fragment baseFragment;

    private List<DrowerOutsidePOJO> drawerOutsideList;
    private List<DrowerOutsidePOJO> leftDraweList;
    private List<DrowerOutsidePOJO> drawerOutsideListProduct;
    private List<BrandPOJO> brandList;
    private List<CashManagementPOJO> cashList;
    Context context;
    private String[] rightListStrings;
//    private RecyclerView recyclerViewProductList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        context = MainActivity.this;
//        fragmentDataObserver = (FragmentDataObserver) this.context;
//        baseFragment = new Fragment();
//        fragmentDataObserver = (FragmentDataObserver) baseFragment;

        setTheme(R.style.DrawerArrowStyle);
        frameLayoutcontainer = (FrameLayout) findViewById(R.id.frameLayoutcontainer);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        leftList = (ListView) findViewById(R.id.left_list);
        rightList = (ListView) findViewById(R.id.right_list);
        rightList.setVisibility(View.GONE);


//        recyclerViewProductList = (RecyclerView) findViewById(R.id.recyclerViewProductList);
        drawerOutsideList = new ArrayList<>();
        drawerOutsideListProduct = new ArrayList<>();
        leftDraweList = new ArrayList<>();

        DrowerOutsidePOJO leftListPOJO = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Sell", false);
        DrowerOutsidePOJO leftListPOJO1 = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Products", false);

        leftDraweList.add(leftListPOJO);
        leftDraweList.add(leftListPOJO1);


        DrowerOutsidePOJO listPOJO = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Sell Screen", false);
        DrowerOutsidePOJO listPOJO1 = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Sales History", false);
        DrowerOutsidePOJO listPOJO2 = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Cash Management", false);
        DrowerOutsidePOJO listPOJO3 = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Close Register", false);
        DrowerOutsidePOJO listPOJO4 = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Dashboard", false);
        DrowerOutsidePOJO listPOJO5 = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Settings", false);

        DrowerOutsidePOJO listPOJOProduct = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Products", false);
        DrowerOutsidePOJO listPOJO1Product = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Stock Control", false);
        DrowerOutsidePOJO listPOJO2Product = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Price Books", false);
        DrowerOutsidePOJO listPOJO3Product = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Product Types", false);
        DrowerOutsidePOJO listPOJO4Product = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Suppliers", false);
        DrowerOutsidePOJO listPOJO5Product = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Brands", false);
        DrowerOutsidePOJO listPOJO6Product = new DrowerOutsidePOJO(R.drawable.shopping_cart, "Product Tags", false);

        drawerOutsideList.add(listPOJO);
        drawerOutsideList.add(listPOJO1);
        drawerOutsideList.add(listPOJO2);
        drawerOutsideList.add(listPOJO3);
        drawerOutsideList.add(listPOJO4);
        drawerOutsideList.add(listPOJO5);

        drawerOutsideListProduct.add(listPOJOProduct);
        drawerOutsideListProduct.add(listPOJO1Product);
        drawerOutsideListProduct.add(listPOJO2Product);
        drawerOutsideListProduct.add(listPOJO3Product);
        drawerOutsideListProduct.add(listPOJO4Product);
        drawerOutsideListProduct.add(listPOJO5Product);
        drawerOutsideListProduct.add(listPOJO6Product);


        leftList.setAdapter(new MayAdapter(MainActivity.this, R.layout.drawer_list_row, leftDraweList));

        leftList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {


                if (arg2 == 0) {

                    rightListStrings = getResources().getStringArray(R.array.right1);
                    flag = 1;

                    rightList.setAdapter(new MayAdapter(MainActivity.this, R.layout.drawer_list_row, drawerOutsideList));
                    rightList.setVisibility(View.VISIBLE);
                }
                if (arg2 == 1) {

                    rightListStrings = getResources().getStringArray(R.array.right2);

                    rightList.setAdapter(new MayAdapter(MainActivity.this, R.layout.drawer_list_row, drawerOutsideListProduct));
                    rightList.setVisibility(View.VISIBLE);
                    flag = 2;
                }
                if (arg2 == 2) {

                    rightListStrings = getResources().getStringArray(R.array.right3);

                    rightList.setAdapter(new MayAdapter(MainActivity.this, R.layout.drawer_list_row, drawerOutsideList));
                    rightList.setVisibility(View.VISIBLE);

                }
                if (arg2 == 3) {

                    rightListStrings = getResources().getStringArray(R.array.right3);

                    rightList.setAdapter(new MayAdapter(MainActivity.this, R.layout.drawer_list_row, drawerOutsideList));
                    rightList.setVisibility(View.VISIBLE);

                }
                if (arg2 == 4) {

                    rightListStrings = getResources().getStringArray(R.array.right3);

                    rightList.setAdapter(new MayAdapter(MainActivity.this, R.layout.drawer_list_row, drawerOutsideList));
                    rightList.setVisibility(View.VISIBLE);

                }
                if (arg2 == 5) {

                    rightListStrings = getResources().getStringArray(R.array.right3);

                    rightList.setAdapter(new MayAdapter(MainActivity.this, R.layout.drawer_list_row, drawerOutsideList));
                    rightList.setVisibility(View.VISIBLE);

                }
            }

        });


        rightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                drawer.closeDrawers();


                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                if (arg2 == 0) {

                    if (flag == 1) {
                        FragmentSalesScreen fragmentCashFragment = new FragmentSalesScreen();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentCashFragment, "Product Fragment");
                        fragmentTransaction.commit();

                    } else {
                        ProductListFragment fragmentCashFragment = new ProductListFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentCashFragment);
                        fragmentTransaction.commit();
                    }
                }
                if (arg2 == 1) {


                    if (flag == 1) {
                        SaleHistoryFragment fragmentCashFragment = new SaleHistoryFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentCashFragment, "Product Fragment");
                        fragmentTransaction.commit();
                    } else {
                        StockControlFragment fragmentCashFragment = new StockControlFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentCashFragment);
                        fragmentTransaction.commit();
                    }
                }
                if (arg2 == 2) {

                    if (flag == 1) {

                        CashManagementFragment fragmentPriceFragment = new CashManagementFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentPriceFragment, "Price Book ");
                        fragmentTransaction.commit();

                    } else {

                        PriceBookFragment fragmentPriceFragment = new PriceBookFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentPriceFragment, "Price Book ");
                        fragmentTransaction.commit();
                    }

                }
                if (arg2 == 3) {

                    if (flag == 1) {
                        CloseRegisterFragment fragmentProductType = new CloseRegisterFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentProductType, "Price Book ");
                        fragmentTransaction.commit();
                    } else {
                        ProductTypeFragment fragmentPriceFragment = new ProductTypeFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentPriceFragment, "Price Book ");
                        fragmentTransaction.commit();
                    }


                }
                if (arg2 == 4) {
                    if (flag == 1) {
                        DashBoardFragment fragmentBrand = new DashBoardFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentBrand, "Brands");
                        fragmentTransaction.commit();
                    } else {
                        SupplierFragment fragmentBrand = new SupplierFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentBrand, "Supplier");
                        fragmentTransaction.commit();
                    }


                }
                if (arg2 == 5) {
                    if (flag == 1) {
                        SettingsFragment fragmentBrand = new SettingsFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentBrand, "Brands");
                        fragmentTransaction.commit();
                    } else {
                        BrandFragment fragmentBrand = new BrandFragment();
                        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentBrand, "Brands");
                        fragmentTransaction.commit();
                    }
                }
                if (arg2 == 6) {

                    ProductTagsFragment fragmentProductTags = new ProductTagsFragment();
                    fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentProductTags, "Product Tags");
                    fragmentTransaction.commit();

                }
            }

        });


        // Set the drawer toggle as the DrawerListener
//        getActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeButtonEnabled(true);
       /* drawer.setDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDrawerSlide(View arg0, float arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDrawerOpened(View arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDrawerClosed(View arg0) {
                // TODO Auto-generated method stub
                rightList.setVisibility(View.GONE);
            }
        }); */


        drawer = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                    /* host Activity */
                drawer,                    /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                rightList.setVisibility(View.GONE);
                // invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

        };


        // Set the drawer toggle as the DrawerListener
        drawer.setDrawerListener(mDrawerToggle);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        FragmentSalesScreen fragmentCashFragment = new FragmentSalesScreen();
        fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentCashFragment, "Product Fragment");
        fragmentTransaction.commit();

    }

    public String sendsDataToFragment(String data)
    {

        return data;
    }
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Are you sure you want to close VendHQ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onDataAvailable(String data) {

//       fragmentDataObserver.getDataFromActivity(data);

    }

    @Override
    public void showDelayIndicator() {

    }

    @Override
    public void showErrorView(String errorMsg) {

    }

    @Override
    public void hideDelayIndicator() {

    }

    @Override
    public void grtStringFromId(int resId, String... name) {

    }

    class MayAdapter extends ArrayAdapter<DrowerOutsidePOJO> {

        List<DrowerOutsidePOJO> myList = null;

        public MayAdapter(Context context, int resource, List<DrowerOutsidePOJO> objects) {
            super(context, resource, objects);
            myList = objects;
        }

        public List<DrowerOutsidePOJO> getMyList() {
            return myList;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.drawer_list_row, null);//set layout for displaying items


            TextView tv = (TextView) convertView.findViewById(R.id.txtvwTitle);
            TextView tv2 = (TextView) convertView.findViewById(R.id.txtVwIsOpen);
            tv.setVisibility(View.GONE);
            tv2.setText(myList.get(position).getName());
            return convertView;
        }

        public void setMyList(List<DrowerOutsidePOJO> myList) {
            this.myList = myList;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
//        int id = item.getItemId();
//        if (id == R.id.action_search) {
//            return false;
//        }
//        else
//        {
//
//        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


}

