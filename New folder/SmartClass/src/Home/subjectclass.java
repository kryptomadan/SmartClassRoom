// this class is used for storing the subject objects 
package Home;
public class subjectclass {
public String sub;
public String subid;
public String getSub() {
	return sub;
}
public void setSub(String sub) {
	this.sub = sub;
}
public String getSubid() {
	return subid;
}
public void setSubid(String subid) {
	this.subid = subid;
}
public subjectclass(String sub, String subid) {
	super();
	this.sub = sub;
	this.subid = subid;
}
@Override
public String toString() {
	return "subjectclass [sub=" + sub + ", subid=" + subid + "]";
}


}
