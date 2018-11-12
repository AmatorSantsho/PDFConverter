package interfaces;


import util.ScriptException;

import java.util.Map;

public interface IScriptRunner {

  Object evaluateScript(Map<String, Object> context, String scriptName) throws ScriptException;

}
