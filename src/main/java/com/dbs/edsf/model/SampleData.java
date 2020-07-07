package com.dbs.edsf.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SampleData {

/*
	public List<UserProfile> buildUserProfile() {
			*//*List<UserProfile> userProfiles = new ArrayList<>();
		userProfiles.add(new UserProfile("vijay","ns"));
		userProfiles.add(new UserProfile("nishant","ns,ns_pni"));
		userProfiles.add(new UserProfile("abhishek","all"));

		return userProfiles;
	}*//*

		 *//*public List<UserProfile> buildUserProfile1() {
		List<UserProfile> userProfiles = new ArrayList<>();
		//user,tble,
		HashMap<String, Cu>
		HashMap<String, HashMap<String, UserTableMapping>> hm = new HashMap<>();
		*//**//*userProfiles.add(new UserProfile("vijay_table","select,update"));
		userProfiles.add(new UserProfile("nishant","ns,ns_pni"));
		userProfiles.add(new UserProfile("abhishek","all"));*//**//*

		hm.put("vijay",)


		return userProfiles;
	}*//*


	public List<TableProfile> buildTableProfile() {
		List<TableProfile> tableProfile = new ArrayList<>();
		tableProfile.add(new TableProfile("Table1_ns","col1,col2,col3"));
		tableProfile.add(new TableProfile("Table1_ns_npi","col1,col2,col3,udf(col4),udf(col5)"));
		tableProfile.add(new TableProfile("Table1_all","col1,col2,col3,udf(col4),udf(col5),udf(col6),udf(col7)"));
		tableProfile.add(new TableProfile("Table2_ns","col1,col3"));
		tableProfile.add(new TableProfile("Table2_ns_npi","col1,col3,udf(col2),udf(col4),udf(col5)"));
		tableProfile.add(new TableProfile("Table2_all","col1,col3,udf(col2),udf(col4),udf(col5),udf(col6)"));

		return tableProfile;
	}

	public List<UserAnchorPoints> buildUserAnchorPoints() {
		List<UserAnchorPoints> userAnchorPoints = new ArrayList<>();
		userAnchorPoints.add(new UserAnchorPoints("vijay_Table1","IN,EDSF"));
		userAnchorPoints.add(new UserAnchorPoints("nishant_Table2","SG,EDSF"));
		userAnchorPoints.add(new UserAnchorPoints("abhishek_Table1","IN,SG,EDSF,IBG"));
		return userAnchorPoints;
	}
}
*/
}
