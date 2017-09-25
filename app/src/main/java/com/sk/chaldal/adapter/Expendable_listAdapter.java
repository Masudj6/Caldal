package com.sk.chaldal.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sk.chaldal.R;
import com.sk.chaldal.model.HeaderDataModel;

import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by sk on 9/20/2017.
 */

public class Expendable_listAdapter extends BaseExpandableListAdapter {

    private HeaderDataModel headerModel;
    private Context context;
    private List<HeaderDataModel> listDataHeader;
    private HashMap<String, List<String>> listHashMap;

    public Expendable_listAdapter(Context context, List<HeaderDataModel> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        Log.e(TAG, "getGroupCount: ");
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        Log.e(TAG, "getChildrenCount: ");
        return listHashMap.get(listDataHeader.get(i).getHeaderName()).size();
    }

    @Override
    public Object getGroup(int i) {
        Log.e(TAG, "getGroup: ");
        headerModel = new HeaderDataModel(listDataHeader.get(i).getHeaderName(), listDataHeader.get(i).getImage());
//        return listDataHeader.get(i).getHeaderName();
        return headerModel;
    }

    @Override
    public Object getChild(int i, int i1) {
        Log.e(TAG, "getChild: ");
        Log.e(TAG, "isChildSelectable: group = " + i + " & child = " + i1);
        return listHashMap.get(listDataHeader.get(i).getHeaderName()).get(i1); // i = Group Item , i1 = ChildItem
    }

    @Override
    public long getGroupId(int i) {
        Log.e(TAG, "getGroupId: ");
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        Log.e(TAG, "getChildId: ");
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        Log.e(TAG, "hasStableIds: ");
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        Log.e(TAG, "getGroupView: ");
        headerModel = (HeaderDataModel) getGroup(i);
//        String headerTitle = (String) getGroup(i);
        String headerTitle = headerModel.getHeaderName();
        int headerIcon = headerModel.getImage();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group_exlist, null);
        }
        TextView lblListHeader = (TextView) view.findViewById(R.id.lblListHeader);
        ImageView iv_groupIcon = (ImageView) view.findViewById(R.id.iv_groupIcon);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        iv_groupIcon.setImageResource(headerIcon);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Log.e(TAG, "getChildView: ");
        final String childText = (String) getChild(i, i1);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_child_exlist, null);
        }

        TextView txtListChild = (TextView) view.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        Log.e(TAG, "isChildSelectable: ");
        return true;
    }
}