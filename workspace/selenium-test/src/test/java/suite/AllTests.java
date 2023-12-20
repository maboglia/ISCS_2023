package suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("tests")//tutte le classi del/i package/s
//@SelectClasses({})//singole classi
public class AllTests {}