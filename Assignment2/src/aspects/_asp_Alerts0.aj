package aspects;

import larva.*;
public aspect _asp_Alerts0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_Alerts0.initialize();
}
}
before () : (call(* *.checkNumberOfAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 50/*checkNumberOfAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 50/*checkNumberOfAlerts*/);
}
}
before () : (call(* *.DataErrorOutput(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 52/*DataErrorOutput*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 52/*DataErrorOutput*/);
}
}
before () : (call(* *.Alerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 34/*Alerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 34/*Alerts*/);
}
}
before () : (call(* *.unsuccesfulDelete(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 42/*unsuccesfulDelete*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 42/*unsuccesfulDelete*/);
}
}
before () : (call(* *.dataPostedSuccesfully(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 46/*dataPostedSuccesfully*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 46/*dataPostedSuccesfully*/);
}
}
before () : (call(* *.succesfulDelete(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 40/*succesfulDelete*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 40/*succesfulDelete*/);
}
}
before () : (call(* *.checkAlertsData(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 44/*checkAlertsData*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 44/*checkAlertsData*/);
}
}
before () : (call(* *.dataPostedUnsuccesfully(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 48/*dataPostedUnsuccesfully*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 48/*dataPostedUnsuccesfully*/);
}
}
before () : (call(* *.PostedUnsuccesfully(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 38/*PostedUnsuccesfully*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 38/*PostedUnsuccesfully*/);
}
}
before () : (call(* *.PostedSuccesfully(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 36/*PostedSuccesfully*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 36/*PostedSuccesfully*/);
}
}
}