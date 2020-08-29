package cn.eggschat.controllers;

import cn.eggschat.dto.Result;
import org.nutz.log.Log;
import org.nutz.log.Logs;

public abstract class AbsController {
    public Log log = Logs.get();

    protected Result success(){
        return Result.SUCCESS();
    }

    protected Result success(String msg){
        return Result.SUCCESS(msg);
    }

    protected Result error(){
        return Result.ERROR();
    }

    protected Result error(String msg){
        return Result.ERROR(msg);
    }
}
