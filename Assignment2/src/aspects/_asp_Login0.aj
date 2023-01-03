package aspects;

import larva.*;
public aspect _asp_Login0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_Login0.initialize();
}
}
before () : (call(* *.viewAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Login0.lock){

_cls_Login0 _cls_inst = _cls_Login0._get_cls_Login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 30/*viewAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 30/*viewAlerts*/);
}
}
before () : (call(* *.incorrectLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Login0.lock){

_cls_Login0 _cls_inst = _cls_Login0._get_cls_Login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 28/*incorrectLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 28/*incorrectLogin*/);
}
}
before () : (call(* *.purpouselyLoggedOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Login0.lock){

_cls_Login0 _cls_inst = _cls_Login0._get_cls_Login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 32/*purpouselyLoggedOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 32/*purpouselyLoggedOut*/);
}
}
before () : (call(* *.correctLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Login0.lock){

_cls_Login0 _cls_inst = _cls_Login0._get_cls_Login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 26/*correctLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 26/*correctLogin*/);
}
}
}