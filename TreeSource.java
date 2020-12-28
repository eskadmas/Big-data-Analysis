package thesis_second_task;

import java.util.HashMap;
import java.util.Map;

/*
	@ATTRIBUTE buying {high,low,med,vhigh}
	@ATTRIBUTE maint {high,low,med,vhigh}
	@ATTRIBUTE doors {2,3,4,5more}
	@ATTRIBUTE persons {2,4,more}
	@ATTRIBUTE lug_boot {big,med,small}
	@ATTRIBUTE safety {high,low,med}
	@ATTRIBUTE class {acc,good,unacc,vgood} 
*/

class TreeSource {
	
	  public static Map<String, String> path = new HashMap<String, String>();
	
	  public static double classify(Object[] i) throws Exception {
		path.clear();
	    double p = Double.NaN;
	    p = TreeSource.N22927a810(i);
	    
	    if(p == 0)
	    	path.put(new String("class"), new String("acc"));
	    if(p == 1)
	    	path.put(new String("class"), new String("good"));
	    if(p == 2)
	    	path.put(new String("class"), new String("unacc"));
	    if(p == 3)
	    	path.put(new String("class"), new String("vgood"));
	    
	    return p;
	  }
	  
	  static double N22927a810(Object []i) {
	    double p = Double.NaN;
	    if (i[5] == null) {
	    	path.put(new String("safety"), new String("null"));
	        p = 2;
	    } else if (i[5].equals("high")) {
	    	path.put(new String("safety"), new String("high"));
	        p = TreeSource.N61e4705b1(i);
	    } else if (i[5].equals("low")) {
	    	path.put(new String("safety"), new String("low"));
	        p = 2;
	    } else if (i[5].equals("med")) {
	    	path.put(new String("safety"), new String("med"));
	    	p = TreeSource.N1a93a7ca22(i);
	    } 
	    return p;
	  }
	  
	  static double N61e4705b1(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	    	path.put(new String("persons"), new String("null"));
	    	p = 2;
	    } else if (i[3].equals("2")) {
	    	path.put(new String("persons"), new String("2"));
	    	p = 2;
	    } else if (i[3].equals("4")) {
	    	path.put(new String("persons"), new String("4"));
	    	p = TreeSource.N501348942(i);
	    } else if (i[3].equals("more")) {
	    	path.put(new String("persons"), new String("more"));
	    	p = TreeSource.N20fa23c112(i);
	    } 
	    return p;
	  }
	  
	  static double N501348942(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	    	path.put(new String("buying"), new String("null"));
	    	p = 0;
	    } else if (i[0].equals("high")) {
	    	path.put(new String("buying"), new String("high"));
	    	p = TreeSource.N2957fcb03(i);
	    } else if (i[0].equals("low")) {
	    	path.put(new String("buying"), new String("low"));
	    	p = TreeSource.N1376c05c4(i);
	    } else if (i[0].equals("med")) {
	    	path.put(new String("buying"), new String("med"));
	    	p = TreeSource.N28ba21f38(i);
	    } else if (i[0].equals("vhigh")) {
	    	path.put(new String("buying"), new String("vhigh"));
	    	p = TreeSource.N593634ad11(i);
	    } 
	    return p;
	  }
	  
	  static double N2957fcb03(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N1376c05c4(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = TreeSource.N51521cc15(i);
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = TreeSource.N1b4fb9976(i);
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = TreeSource.Ndeb64327(i);
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N51521cc15(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N1b4fb9976(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 1;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 1;
	    } 
	    return p;
	  }
	  
	  static double Ndeb64327(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 1;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 1;
	    } 
	    return p;
	  }
	  
	  static double N28ba21f38(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = TreeSource.N694f94319(i);
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = TreeSource.Nf2a0b8e10(i);
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N694f94319(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 1;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 1;
	    } 
	    return p;
	  }
	  
	  static double Nf2a0b8e10(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N593634ad11(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 2;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 2;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N20fa23c112(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	    	path.put(new String("buying"), new String("null"));
	    	p = 0;
	    } else if (i[0].equals("high")) {
	    	path.put(new String("buying"), new String("high"));
	    	p = TreeSource.N3581c5f313(i);
	    } else if (i[0].equals("low")) {
	    	path.put(new String("buying"), new String("low"));
	    	p = TreeSource.N6aa8ceb614(i);
	    } else if (i[0].equals("med")) {
	    	path.put(new String("buying"), new String("med"));
	    	p = TreeSource.N64a294a618(i);
	    } else if (i[0].equals("vhigh")) {
	    	path.put(new String("buying"), new String("vhigh"));
	    	p = TreeSource.N6ae4099421(i);
	    } 
	    return p;
	  }
	  
	  static double N3581c5f313(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N6aa8ceb614(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 3;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = TreeSource.N2530c1215(i);
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = TreeSource.N73c6c3b216(i);
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = TreeSource.N48533e6417(i);
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N2530c1215(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 3;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N73c6c3b216(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 3;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 1;
	    } 
	    return p;
	  }
	  
	  static double N48533e6417(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 3;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 1;
	    } 
	    return p;
	  }
	  
	  static double N64a294a618(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = TreeSource.N7e0b37bc19(i);
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = TreeSource.N3b95a09c20(i);
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N7e0b37bc19(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 3;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 1;
	    } 
	    return p;
	  }
	  
	  static double N3b95a09c20(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 3;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 3;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 3;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N6ae4099421(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 2;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 2;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N1a93a7ca22(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	    	path.put(new String("persons"), new String("null"));
	    	p = 2;
	    } else if (i[3].equals("2")) {
	    	path.put(new String("persons"), new String("2"));
	    	p = 2;
	    } else if (i[3].equals("4")) {
	    	path.put(new String("persons"), new String("4"));
	    	p = TreeSource.N3d82c5f323(i);
	    } else if (i[3].equals("more")) {
	    	path.put(new String("persons"), new String("more"));
	    	p = TreeSource.N4cdf35a938(i);
	    } 
	    return p;
	  }
	  
	  static double N3d82c5f323(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	    	path.put(new String("buying"), new String("null"));
	    	p = 2;
	    } else if (i[0].equals("high")) {
	    	path.put(new String("buying"), new String("high"));
	    	p = TreeSource.N2b05039f24(i);
	    } else if (i[0].equals("low")) {
	    	path.put(new String("buying"), new String("low"));
	    	p = TreeSource.N4dcbadb427(i);
	    } else if (i[0].equals("med")) {
	    	path.put(new String("buying"), new String("med"));
	    	p = TreeSource.Nba8a1dc31(i);
	    } else if (i[0].equals("vhigh")) {
	    	path.put(new String("buying"), new String("vhigh"));
	    	p = TreeSource.N759ebb3d35(i);
	    } 
	    return p;
	  }
	  
	  static double N2b05039f24(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 0;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = TreeSource.N61e717c225(i);
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = TreeSource.N66cd51c326(i);
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N61e717c225(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N66cd51c326(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	    	path.put(new String("doors"), new String("null"));
	    	p = 2;
	    } else if (i[2].equals("2")) {
	    	path.put(new String("doors"), new String("2"));
	    	p = 2;
	    } else if (i[2].equals("3")) {
	    	path.put(new String("doors"), new String("3"));
	    	p = 2;
	    } else if (i[2].equals("4")) {
	    	path.put(new String("doors"), new String("4"));
	    	p = 0;
	    } else if (i[2].equals("5more")) {
	    	path.put(new String("doors"), new String("5more"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N4dcbadb427(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = TreeSource.N4e51566928(i);
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = TreeSource.N17d1016629(i);
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = TreeSource.N1b9e191630(i);
	    } 
	    return p;
	  }
	  
	  static double N4e51566928(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 1;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 1;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N17d1016629(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 1;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 1;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N1b9e191630(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 0;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 0;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double Nba8a1dc31(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = TreeSource.N4f8e5cde32(i);
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = TreeSource.N504bae7833(i);
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = TreeSource.N3b764bce34(i);
	    } 
	    return p;
	  }
	  
	  static double N4f8e5cde32(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 0;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 0;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N504bae7833(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 1;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 1;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N3b764bce34(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 0;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 0;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N759ebb3d35(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 2;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 2;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = TreeSource.N484b61fc36(i);
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = TreeSource.N45fe3ee337(i);
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N484b61fc36(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 0;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 0;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N45fe3ee337(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 0;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = 0;
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = 0;
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N4cdf35a938(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	    	path.put(new String("lug_boot"), new String("null"));
	    	p = 0;
	    } else if (i[4].equals("big")) {
	    	path.put(new String("lug_boot"), new String("big"));
	    	p = TreeSource.N4c98385c39(i);
	    } else if (i[4].equals("med")) {
	    	path.put(new String("lug_boot"), new String("med"));
	    	p = TreeSource.N73a8dfcc44(i);
	    } else if (i[4].equals("small")) {
	    	path.put(new String("lug_boot"), new String("small"));
	    	p = TreeSource.Naec635448(i);
	    } 
	    return p;
	  }
	  
	  static double N4c98385c39(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	    	path.put(new String("buying"), new String("null"));
	    	p = 0;
	    } else if (i[0].equals("high")) {
	    	path.put(new String("buying"), new String("high"));
	    	p = TreeSource.N5fcfe4b240(i);
	    } else if (i[0].equals("low")) {
	    	path.put(new String("buying"), new String("low"));
	    	p = TreeSource.N6bf2d08e41(i);
	    } else if (i[0].equals("med")) {
	    	path.put(new String("buying"), new String("med"));
	    	p = TreeSource.N5eb5c22442(i);
	    } else if (i[0].equals("vhigh")) {
	    	path.put(new String("buying"), new String("vhigh"));
	    	p = TreeSource.N53e25b7643(i);
	    } 
	    return p;
	  }
	  
	  static double N5fcfe4b240(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N6bf2d08e41(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 1;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 1;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N5eb5c22442(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 1;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N53e25b7643(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 2;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 2;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N73a8dfcc44(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	    	path.put(new String("buying"), new String("null"));
	    	p = 0;
	    } else if (i[0].equals("high")) {
	    	path.put(new String("buying"), new String("high"));
	    	p = TreeSource.Nea3079745(i);
	    } else if (i[0].equals("low")) {
	    	path.put(new String("buying"), new String("low"));
	    	p = TreeSource.N7e77408546(i);
	    } else if (i[0].equals("med")) {
	    	path.put(new String("buying"), new String("med"));
	    	p = 0;
	    } else if (i[0].equals("vhigh")) {
	    	path.put(new String("buying"), new String("vhigh"));
	    	p = TreeSource.N3f8f9dd647(i);
	    } 
	    return p;
	  }
	  
	  static double Nea3079745(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N7e77408546(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 1;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 1;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 0;
	    } 
	    return p;
	  }
	  
	  static double N3f8f9dd647(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 2;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 2;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double Naec635448(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	    	path.put(new String("buying"), new String("null"));
	    	p = 2;
	    } else if (i[0].equals("high")) {
	    	path.put(new String("buying"), new String("high"));
	    	p = 2;
	    } else if (i[0].equals("low")) {
	    	path.put(new String("buying"), new String("low"));
	    	p = TreeSource.N1c65522149(i);
	    } else if (i[0].equals("med")) {
	    	path.put(new String("buying"), new String("med"));
	    	p = TreeSource.N58d25a4050(i);
	    } else if (i[0].equals("vhigh")) {
	    	path.put(new String("buying"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N1c65522149(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 0;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 0;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	  static double N58d25a4050(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	    	path.put(new String("maint"), new String("null"));
	    	p = 2;
	    } else if (i[1].equals("high")) {
	    	path.put(new String("maint"), new String("high"));
	    	p = 2;
	    } else if (i[1].equals("low")) {
	    	path.put(new String("maint"), new String("low"));
	    	p = 0;
	    } else if (i[1].equals("med")) {
	    	path.put(new String("maint"), new String("med"));
	    	p = 0;
	    } else if (i[1].equals("vhigh")) {
	    	path.put(new String("maint"), new String("vhigh"));
	    	p = 2;
	    } 
	    return p;
	  }
	  
	}