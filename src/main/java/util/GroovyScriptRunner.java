package util;

import groovy.lang.Binding;
import groovy.lang.GroovyRuntimeException;
import groovy.lang.GroovyShell;
import interfaces.IResourceScriptProvider;
import interfaces.IScriptRunner;

import java.util.Date;
import java.util.Map;

/**
 * Groovy script runner - runs the groovy script. The script is taken from shared storage, 'pdfparsing' folder. Script
 * name should be the exact file name.
 */
public class GroovyScriptRunner implements IScriptRunner {


  private final IResourceScriptProvider scriptProvider;

  /**
   * For unit-tests
   */
  public GroovyScriptRunner(IResourceScriptProvider scriptProvider) {
    this.scriptProvider = scriptProvider;
  }


  public Object evaluateScript(Map<String, Object> context, String scriptName) throws ScriptException {

    long startTime = new Date().getTime();
    Binding binding = new Binding();
    for (String variable : context.keySet()) {
      binding.setVariable(variable, context.get(variable));
    }
    Object res = null;
    try {
      GroovyShell shell = new GroovyShell(binding);
      String script = scriptProvider.getResource(scriptName);
      if (script != null) {
        res = shell.evaluate(script);
      }
    } catch (GroovyRuntimeException e) {
      System.out.println("Script evaluation failed with exception");
      throw new ScriptException(e);
    }
    System.out.println("Script evaluation is done, time = " + (new Date().getTime() - startTime) + "ms");
    return res;
  }

}
