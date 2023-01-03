package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_Alerts0 implements _callable{

public static PrintWriter pw; 
public static _cls_Alerts0 root;

public static LinkedHashMap<_cls_Alerts0,_cls_Alerts0> _cls_Alerts0_instances = new LinkedHashMap<_cls_Alerts0,_cls_Alerts0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\gabri\\workspace\\Assignment2/src/output_Alerts.txt");

root = new _cls_Alerts0();
_cls_Alerts0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_Alerts0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_Alerts0() {
}

public void initialisation() {
}

public static _cls_Alerts0 _get_cls_Alerts0_inst() { synchronized(_cls_Alerts0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_Alerts0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_Alerts0_instances){
_performLogic_alerts(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_Alerts0[] a = new _cls_Alerts0[1];
synchronized(_cls_Alerts0_instances){
a = _cls_Alerts0_instances.keySet().toArray(a);}
for (_cls_Alerts0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_Alerts0_instances){
_cls_Alerts0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_alerts = 29;

public void _performLogic_alerts(String _info, int... _event) {

_cls_Alerts0.pw.println("[alerts]AUTOMATON::> alerts("+") STATE::>"+ _string_alerts(_state_id_alerts, 0));
_cls_Alerts0.pw.flush();

if (0==1){}
else if (_state_id_alerts==26){
		if (1==0){}
		else if ((_occurredEvent(_event,44/*checkAlertsData*/))){
		_cls_Alerts0.pw .println ("PopulatedAlertsList -> CheckAlertsData");

		_state_id_alerts = 27;//moving to state CheckAlertsData
		_goto_alerts(_info);
		}
}
else if (_state_id_alerts==27){
		if (1==0){}
		else if ((_occurredEvent(_event,52/*DataErrorOutput*/))){
		_cls_Alerts0.pw .println ("CheckAlertsData -> IncorrectPostData");

		_state_id_alerts = 22;//moving to state IncorrectPostData
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,50/*checkNumberOfAlerts*/))){
		_cls_Alerts0.pw .println ("CheckAlertsData -> ThreeAlertsCheck");

		_state_id_alerts = 28;//moving to state ThreeAlertsCheck
		_goto_alerts(_info);
		}
}
else if (_state_id_alerts==29){
		if (1==0){}
		else if ((_occurredEvent(_event,42/*unsuccesfulDelete*/))){
		_cls_Alerts0.pw .println ("ViewingAlerts -> UnintentionallyPopulatedAlertsList");

		_state_id_alerts = 20;//moving to state UnintentionallyPopulatedAlertsList
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,40/*succesfulDelete*/))){
		_cls_Alerts0.pw .println ("ViewingAlerts -> EmptyAlertsList");

		_state_id_alerts = 25;//moving to state EmptyAlertsList
		_goto_alerts(_info);
		}
}
else if (_state_id_alerts==25){
		if (1==0){}
		else if ((_occurredEvent(_event,36/*PostedSuccesfully*/))){
		_cls_Alerts0.pw .println ("EmptyAlertsList -> PopulatedAlertsList");

		_state_id_alerts = 26;//moving to state PopulatedAlertsList
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,38/*PostedUnsuccesfully*/))){
		_cls_Alerts0.pw .println ("EmptyAlertsList -> UnpopulatedAlertsList");

		_state_id_alerts = 21;//moving to state UnpopulatedAlertsList
		_goto_alerts(_info);
		}
}
else if (_state_id_alerts==28){
		if (1==0){}
		else if ((_occurredEvent(_event,48/*dataPostedUnsuccesfully*/))){
		_cls_Alerts0.pw .println ("ThreeAlertsCheck -> IncorrectAmountOfAlerts");

		_state_id_alerts = 23;//moving to state IncorrectAmountOfAlerts
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,46/*dataPostedSuccesfully*/))){
		_cls_Alerts0.pw .println ("ThreeAlertsCheck -> PostedSuccesfully");

		_state_id_alerts = 24;//moving to state PostedSuccesfully
		_goto_alerts(_info);
		}
}
}

public void _goto_alerts(String _info){
_cls_Alerts0.pw.println("[alerts]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alerts(_state_id_alerts, 1));
_cls_Alerts0.pw.flush();
}

public String _string_alerts(int _state_id, int _mode){
switch(_state_id){
case 23: if (_mode == 0) return "IncorrectAmountOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  IncorrectAmountOfAlerts";
case 20: if (_mode == 0) return "UnintentionallyPopulatedAlertsList"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  UnintentionallyPopulatedAlertsList";
case 22: if (_mode == 0) return "IncorrectPostData"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  IncorrectPostData";
case 26: if (_mode == 0) return "PopulatedAlertsList"; else return "PopulatedAlertsList";
case 27: if (_mode == 0) return "CheckAlertsData"; else return "CheckAlertsData";
case 29: if (_mode == 0) return "ViewingAlerts"; else return "ViewingAlerts";
case 24: if (_mode == 0) return "PostedSuccesfully"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  PostedSuccesfully";
case 21: if (_mode == 0) return "UnpopulatedAlertsList"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  UnpopulatedAlertsList";
case 25: if (_mode == 0) return "EmptyAlertsList"; else return "EmptyAlertsList";
case 28: if (_mode == 0) return "ThreeAlertsCheck"; else return "ThreeAlertsCheck";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}