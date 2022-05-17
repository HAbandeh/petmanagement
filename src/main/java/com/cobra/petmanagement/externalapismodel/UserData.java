package com.cobra.petmanagement.externalapismodel;

import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
public class UserData {

    List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
    
    @Override
    	public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for(User user: data) {
    		sb.append("[");
    		sb.append(user.toString());
    		sb.append("]");
    	}
    	
    	return sb.toString();
    	}
}
