/* Generated By:JavaCC: Do not edit this line. ReaderConstants.java */
package Parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ReaderConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SL_COMMENT = 37;
  /** RegularExpression Id. */
  int ML_COMMENT = 38;
  /** RegularExpression Id. */
  int DIGITS = 40;
  /** RegularExpression Id. */
  int LOWER_LETTERS = 41;
  /** RegularExpression Id. */
  int UPPER_LETTERS = 42;
  /** RegularExpression Id. */
  int LACC = 43;
  /** RegularExpression Id. */
  int RACC = 44;
  /** RegularExpression Id. */
  int STAR = 45;
  /** RegularExpression Id. */
  int SEMI = 46;
  /** RegularExpression Id. */
  int PIPE = 47;
  /** RegularExpression Id. */
  int MORETHAN = 48;
  /** RegularExpression Id. */
  int UNAIRE = 49;
  /** RegularExpression Id. */
  int HIT = 50;
  /** RegularExpression Id. */
  int RECOLT = 51;
  /** RegularExpression Id. */
  int EXPLORE = 52;
  /** RegularExpression Id. */
  int BEST = 53;
  /** RegularExpression Id. */
  int FOLLOW = 54;
  /** RegularExpression Id. */
  int MOVE = 55;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_SL_COMMENT = 1;
  /** Lexical state. */
  int IN_ML_COMMENT = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"\\\'\"",
    "\"\\t\"",
    "\"\\r\"",
    "\"\\n\"",
    "\"\"",
    "\"\\u0001\"",
    "\"\\u0002\"",
    "\"\\u0003\"",
    "\"\\u0004\"",
    "\"\\u0005\"",
    "\"\\u0006\"",
    "\"\\u0007\"",
    "\"\\b\"",
    "\"\\u000b\"",
    "\"\\f\"",
    "\"\\u000e\"",
    "\"\\u000f\"",
    "\"\\u0010\"",
    "\"\\u0011\"",
    "\"\\u0012\"",
    "\"\\u0013\"",
    "\"\\u0014\"",
    "\"\\u0015\"",
    "\"\\u0016\"",
    "\"\\u0017\"",
    "\"\\u0018\"",
    "\"\\u0019\"",
    "\"\\u001a\"",
    "\"\\u001b\"",
    "\"\\u001c\"",
    "\"\\u001d\"",
    "\"\\u001e\"",
    "\"\\u001f\"",
    "\"\\u007f\"",
    "\"//\"",
    "\"/*\"",
    "<SL_COMMENT>",
    "\"*/\"",
    "<token of kind 39>",
    "<DIGITS>",
    "<LOWER_LETTERS>",
    "<UPPER_LETTERS>",
    "\"{\"",
    "\"}\"",
    "\"*\"",
    "\";\"",
    "\"|\"",
    "\">\"",
    "<UNAIRE>",
    "\"H\"",
    "\"R\"",
    "\"E\"",
    "\"B\"",
    "\"F\"",
    "\"M\"",
  };

}
