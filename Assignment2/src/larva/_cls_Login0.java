package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_Login0 implements _callable{

public static PrintWriter pw; 
public static _cls_Login0 root;

public static LinkedHashMap<_cls_Login0,_cls_Login0> _cls_Login0_instances = new LinkedHashMap<_cls_Login0,_cls_Login0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\gabri\\workspace\\Assignment2/src/output_Login.txt");

root = new _cls_Login0();
_cls_Login0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_Login0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_Login0() {
}

public void initialisation() {
}

public static _cls_Login0 _get_cls_Login0_inst() { synchronized(_cls_Login0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_Login0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_Login0_instances){
_performLogic_login(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_Login0[] a = new _cls_Login0[1];
synchronized(_cls_Login0_instances){
a = _cls_Login0_instances.keySet().toArray(a);}
for (_cls_Login0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_Login0_instances){
_cls_Login0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_login = 19;

public void _performLogic_login(String _info, int... _event) {

_cls_Login0.pw.println("[login]AUTOMATON::> login("+") STATE::>"+ _string_login(_state_id_login, 0));
_cls_Login0.pw.flush();

if (0==1){}
else if (_state_id_login==15){
		if (1==0){}
		else if ((_occurredEvent(_event,32/*purpouselyLoggedOut*/))){
		_cls_Login0.pw .println ("ViewingAlerts -> LoggedOut");

		_state_id_login = 17;//moving to state PurpouselyloggedOut
		_goto_login(_info);
		}
}
else if (_state_id_login==19){
		if (1==0){}
		else if ((_occurredEvent(_event,28/*incorrectLogin*/))){
		_cls_Login0.pw .println ("loggedOut -> BadLoginError401");

		_state_id_login = 16;//moving to state BadLoginError401
		_goto_login(_info);
		}
		else if ((_occurredEvent(_event,26/*correctLogin*/))){
		_cls_Login0.pw .println ("loggedOut -> loggedIn");

		_state_id_login = 18;//moving to state loggedIn
		_goto_login(_info);
		}
}
else if (_state_id_login==18){
		if (1==0){}
		else if ((_occurredEvent(_event,30/*viewAlerts*/))){
		_cls_Login0.pw .println ("loggedIn - > viewingAlerts");

		_state_id_login = 15;//moving to state viewingAlerts
		_goto_login(_info);
		}
		else if ((_occurredEvent(_event,32/*purpouselyLoggedOut*/))){
		_cls_Login0.pw .println ("LoggedIn -> LoggedOut");

		_state_id_login = 17;//moving to state PurpouselyloggedOut
		_goto_login(_info);
		}
}
}

public void _goto_login(String _info){
_cls_Login0.pw.println("[login]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_login(_state_id_login, 1));
_cls_Login0.pw.flush();
}

public String _string_login(int _state_id, int _mode){
switch(_state_id){
case 15: if (_mode == 0) return "viewingAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  viewingAlerts";
case 18: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 19: if (_mode == 0) return "InitiallyloggedOut"; else return "InitiallyloggedOut";
case 16: if (_mode == 0) return "BadLoginError401"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  BadLoginError401";
case 17: if (_mode == 0) return "PurpouselyloggedOut"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  PurpouselyloggedOut";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}