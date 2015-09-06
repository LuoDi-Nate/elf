namespace java com.fooluodi.thrift.helloworld

struct Helloworld{
	1:i32 id;
	2:string msg;	 
}

service getFirstMsgFromThrift{
	string sayHi()
}
