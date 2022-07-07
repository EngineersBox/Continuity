// Generated from ContinuityLexer.g4 by ANTLR 4.7.1

package com.engineersbox.continuity.instrumenter.lang.antlr;

import com.engineersbox.continuity.instrumenter.lang.lexer.LexerBase;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ContinuityLexer extends LexerBase {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CTX=1, EXT=2, FN=3, STD=4, IF=5, ELSE=6, LET=7, CHAR=8, BOOL=9, INT8=10, 
		INT16=11, INT32=12, INT64=13, FLOAT32=14, FLOAT64=15, STRING=16, OBJECT=17, 
		IntegerLiteral=18, FloatingPointLiteral=19, BooleanLiteral=20, CharacterLiteral=21, 
		StringLiteral=22, NullLiteral=23, LPAREN=24, RPAREN=25, LBRACE=26, RBRACE=27, 
		LBRACK=28, RBRACK=29, SEMI=30, DOT=31, DOLLAR=32, COMMA=33, ARROW=34, 
		ASSIGN=35, GT=36, LT=37, BANG=38, TILDE=39, QUESTION=40, COLON=41, COLONCOLON=42, 
		EQUAL=43, LE=44, GE=45, NOTEQUAL=46, AND=47, OR=48, INC=49, DEC=50, ADD=51, 
		SUB=52, MUL=53, DIV=54, BITAND=55, BITOR=56, CARET=57, MOD=58, Identifier=59, 
		WS=60, COMMENT=61, LINE_COMMENT=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CTX", "EXT", "FN", "STD", "IF", "ELSE", "LET", "CHAR", "BOOL", "INT8", 
		"INT16", "INT32", "INT64", "FLOAT32", "FLOAT64", "STRING", "OBJECT", "IntegerLiteral", 
		"DecimalIntegerLiteral", "HexIntegerLiteral", "OctalIntegerLiteral", "BinaryIntegerLiteral", 
		"IntegerTypeSuffix", "DecimalNumeral", "Digits", "Digit", "NonZeroDigit", 
		"DigitsAndUnderscores", "DigitOrUnderscore", "Underscores", "HexNumeral", 
		"HexDigits", "HexDigit", "HexDigitsAndUnderscores", "HexDigitOrUnderscore", 
		"OctalNumeral", "OctalDigits", "OctalDigit", "OctalDigitsAndUnderscores", 
		"OctalDigitOrUnderscore", "BinaryNumeral", "BinaryDigits", "BinaryDigit", 
		"BinaryDigitsAndUnderscores", "BinaryDigitOrUnderscore", "FloatingPointLiteral", 
		"DecimalFloatingPointLiteral", "ExponentPart", "ExponentIndicator", "SignedInteger", 
		"Sign", "FloatTypeSuffix", "HexadecimalFloatingPointLiteral", "HexSignificand", 
		"BinaryExponent", "BinaryExponentIndicator", "BooleanLiteral", "CharacterLiteral", 
		"SingleCharacter", "StringLiteral", "StringCharacters", "StringCharacter", 
		"EscapeSequence", "OctalEscape", "ZeroToThree", "UnicodeEscape", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "DOT", 
		"DOLLAR", "COMMA", "ARROW", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", 
		"COLON", "COLONCOLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
		"DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", 
		"Identifier", "Letter", "LetterOrDigit", "WS", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'ctx'", "'ext'", "'fn'", "'std'", "'if'", "'else'", "'let'", "'char'", 
		"'bool'", "'int8'", "'int16'", "'int32'", "'int64'", "'float32'", "'float64'", 
		"'str'", "'Object'", null, null, null, null, null, "'null'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "';'", "'.'", "'$'", "','", "'->'", "'='", 
		"'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'::'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
		"'|'", "'^'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CTX", "EXT", "FN", "STD", "IF", "ELSE", "LET", "CHAR", "BOOL", 
		"INT8", "INT16", "INT32", "INT64", "FLOAT32", "FLOAT64", "STRING", "OBJECT", 
		"IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", 
		"StringLiteral", "NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LBRACK", "RBRACK", "SEMI", "DOT", "DOLLAR", "COMMA", "ARROW", "ASSIGN", 
		"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "COLONCOLON", "EQUAL", 
		"LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", 
		"DIV", "BITAND", "BITOR", "CARET", "MOD", "Identifier", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ContinuityLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ContinuityLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 103:
			return Letter_sempred((RuleContext)_localctx, predIndex);
		case 104:
			return LetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean Letter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  checkSupportedSingletonCharacters() ;
		case 1:
			return  checkSupportedSurrogatePairCharacters() ;
		}
		return true;
	}
	private boolean LetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return  checkSupportedSingletonCharacters() ;
		case 3:
			return  checkSupportedSurrogatePairCharacters() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u02cd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\5\23\u0137\n\23\3\24\3\24\5\24\u013b\n\24\3\25\3\25\5\25\u013f\n\25\3"+
		"\26\3\26\5\26\u0143\n\26\3\27\3\27\5\27\u0147\n\27\3\30\3\30\3\31\3\31"+
		"\3\31\5\31\u014e\n\31\3\31\3\31\3\31\5\31\u0153\n\31\5\31\u0155\n\31\3"+
		"\32\3\32\5\32\u0159\n\32\3\32\5\32\u015c\n\32\3\33\3\33\5\33\u0160\n\33"+
		"\3\34\3\34\3\35\6\35\u0165\n\35\r\35\16\35\u0166\3\36\3\36\5\36\u016b"+
		"\n\36\3\37\6\37\u016e\n\37\r\37\16\37\u016f\3 \3 \3 \3 \3!\3!\5!\u0178"+
		"\n!\3!\5!\u017b\n!\3\"\3\"\3#\6#\u0180\n#\r#\16#\u0181\3$\3$\5$\u0186"+
		"\n$\3%\3%\5%\u018a\n%\3%\3%\3&\3&\5&\u0190\n&\3&\5&\u0193\n&\3\'\3\'\3"+
		"(\6(\u0198\n(\r(\16(\u0199\3)\3)\5)\u019e\n)\3*\3*\3*\3*\3+\3+\5+\u01a6"+
		"\n+\3+\5+\u01a9\n+\3,\3,\3-\6-\u01ae\n-\r-\16-\u01af\3.\3.\5.\u01b4\n"+
		".\3/\3/\5/\u01b8\n/\3\60\3\60\3\60\5\60\u01bd\n\60\3\60\5\60\u01c0\n\60"+
		"\3\60\5\60\u01c3\n\60\3\60\3\60\3\60\5\60\u01c8\n\60\3\60\5\60\u01cb\n"+
		"\60\3\60\3\60\3\60\5\60\u01d0\n\60\3\60\3\60\3\60\5\60\u01d5\n\60\3\61"+
		"\3\61\3\61\3\62\3\62\3\63\5\63\u01dd\n\63\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\66\5\66\u01e8\n\66\3\67\3\67\5\67\u01ec\n\67\3\67\3\67\3"+
		"\67\5\67\u01f1\n\67\3\67\3\67\5\67\u01f5\n\67\38\38\38\39\39\3:\3:\3:"+
		"\3:\3:\3:\3:\3:\3:\5:\u0205\n:\3;\3;\3;\3;\3;\3;\3;\3;\5;\u020f\n;\3<"+
		"\3<\3=\3=\5=\u0215\n=\3=\3=\3>\6>\u021a\n>\r>\16>\u021b\3?\3?\5?\u0220"+
		"\n?\3@\3@\3@\3@\5@\u0226\n@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\5A\u0233"+
		"\nA\3B\3B\3C\3C\6C\u0239\nC\rC\16C\u023a\3C\3C\3C\3C\3C\3D\3D\3D\3D\3"+
		"D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3"+
		"O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3W\3X\3X\3X\3Y\3Y\3"+
		"Y\3Z\3Z\3Z\3[\3[\3[\3\\\3\\\3\\\3]\3]\3]\3^\3^\3^\3_\3_\3_\3`\3`\3a\3"+
		"a\3b\3b\3c\3c\3d\3d\3e\3e\3f\3f\3g\3g\3h\3h\7h\u0299\nh\fh\16h\u029c\13"+
		"h\3i\3i\3i\3i\3i\3i\5i\u02a4\ni\3j\3j\3j\3j\3j\3j\5j\u02ac\nj\3k\6k\u02af"+
		"\nk\rk\16k\u02b0\3k\3k\3l\3l\3l\3l\7l\u02b9\nl\fl\16l\u02bc\13l\3l\3l"+
		"\3l\3l\3l\3m\3m\3m\3m\7m\u02c7\nm\fm\16m\u02ca\13m\3m\3m\3\u02ba\2n\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2"+
		"E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\25_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2"+
		"s\26u\27w\2y\30{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\31\u0089\32"+
		"\u008b\33\u008d\34\u008f\35\u0091\36\u0093\37\u0095 \u0097!\u0099\"\u009b"+
		"#\u009d$\u009f%\u00a1&\u00a3\'\u00a5(\u00a7)\u00a9*\u00ab+\u00ad,\u00af"+
		"-\u00b1.\u00b3/\u00b5\60\u00b7\61\u00b9\62\u00bb\63\u00bd\64\u00bf\65"+
		"\u00c1\66\u00c3\67\u00c58\u00c79\u00c9:\u00cb;\u00cd<\u00cf=\u00d1\2\u00d3"+
		"\2\u00d5>\u00d7?\u00d9@\3\2\30\4\2NNnn\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2"+
		"\629\4\2DDdd\3\2\62\63\4\2GGgg\4\2--//\6\2FFHHffhh\4\2RRrr\6\2\f\f\17"+
		"\17))^^\6\2\f\f\17\17$$^^\n\2$$))^^ddhhppttvv\3\2\62\65\6\2&&C\\aac|\4"+
		"\2\2\u0081\ud802\udc01\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\aa"+
		"c|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\2\u02dc\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2]\3\2\2\2"+
		"\2s\3\2\2\2\2u\3\2\2\2\2y\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d"+
		"\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2"+
		"\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af"+
		"\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2"+
		"\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1"+
		"\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2"+
		"\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7"+
		"\3\2\2\2\2\u00d9\3\2\2\2\3\u00db\3\2\2\2\5\u00df\3\2\2\2\7\u00e3\3\2\2"+
		"\2\t\u00e6\3\2\2\2\13\u00ea\3\2\2\2\r\u00ed\3\2\2\2\17\u00f2\3\2\2\2\21"+
		"\u00f6\3\2\2\2\23\u00fb\3\2\2\2\25\u0100\3\2\2\2\27\u0105\3\2\2\2\31\u010b"+
		"\3\2\2\2\33\u0111\3\2\2\2\35\u0117\3\2\2\2\37\u011f\3\2\2\2!\u0127\3\2"+
		"\2\2#\u012b\3\2\2\2%\u0136\3\2\2\2\'\u0138\3\2\2\2)\u013c\3\2\2\2+\u0140"+
		"\3\2\2\2-\u0144\3\2\2\2/\u0148\3\2\2\2\61\u0154\3\2\2\2\63\u0156\3\2\2"+
		"\2\65\u015f\3\2\2\2\67\u0161\3\2\2\29\u0164\3\2\2\2;\u016a\3\2\2\2=\u016d"+
		"\3\2\2\2?\u0171\3\2\2\2A\u0175\3\2\2\2C\u017c\3\2\2\2E\u017f\3\2\2\2G"+
		"\u0185\3\2\2\2I\u0187\3\2\2\2K\u018d\3\2\2\2M\u0194\3\2\2\2O\u0197\3\2"+
		"\2\2Q\u019d\3\2\2\2S\u019f\3\2\2\2U\u01a3\3\2\2\2W\u01aa\3\2\2\2Y\u01ad"+
		"\3\2\2\2[\u01b3\3\2\2\2]\u01b7\3\2\2\2_\u01d4\3\2\2\2a\u01d6\3\2\2\2c"+
		"\u01d9\3\2\2\2e\u01dc\3\2\2\2g\u01e0\3\2\2\2i\u01e2\3\2\2\2k\u01e4\3\2"+
		"\2\2m\u01f4\3\2\2\2o\u01f6\3\2\2\2q\u01f9\3\2\2\2s\u0204\3\2\2\2u\u020e"+
		"\3\2\2\2w\u0210\3\2\2\2y\u0212\3\2\2\2{\u0219\3\2\2\2}\u021f\3\2\2\2\177"+
		"\u0225\3\2\2\2\u0081\u0232\3\2\2\2\u0083\u0234\3\2\2\2\u0085\u0236\3\2"+
		"\2\2\u0087\u0241\3\2\2\2\u0089\u0246\3\2\2\2\u008b\u0248\3\2\2\2\u008d"+
		"\u024a\3\2\2\2\u008f\u024c\3\2\2\2\u0091\u024e\3\2\2\2\u0093\u0250\3\2"+
		"\2\2\u0095\u0252\3\2\2\2\u0097\u0254\3\2\2\2\u0099\u0256\3\2\2\2\u009b"+
		"\u0258\3\2\2\2\u009d\u025a\3\2\2\2\u009f\u025d\3\2\2\2\u00a1\u025f\3\2"+
		"\2\2\u00a3\u0261\3\2\2\2\u00a5\u0263\3\2\2\2\u00a7\u0265\3\2\2\2\u00a9"+
		"\u0267\3\2\2\2\u00ab\u0269\3\2\2\2\u00ad\u026b\3\2\2\2\u00af\u026e\3\2"+
		"\2\2\u00b1\u0271\3\2\2\2\u00b3\u0274\3\2\2\2\u00b5\u0277\3\2\2\2\u00b7"+
		"\u027a\3\2\2\2\u00b9\u027d\3\2\2\2\u00bb\u0280\3\2\2\2\u00bd\u0283\3\2"+
		"\2\2\u00bf\u0286\3\2\2\2\u00c1\u0288\3\2\2\2\u00c3\u028a\3\2\2\2\u00c5"+
		"\u028c\3\2\2\2\u00c7\u028e\3\2\2\2\u00c9\u0290\3\2\2\2\u00cb\u0292\3\2"+
		"\2\2\u00cd\u0294\3\2\2\2\u00cf\u0296\3\2\2\2\u00d1\u02a3\3\2\2\2\u00d3"+
		"\u02ab\3\2\2\2\u00d5\u02ae\3\2\2\2\u00d7\u02b4\3\2\2\2\u00d9\u02c2\3\2"+
		"\2\2\u00db\u00dc\7e\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7z\2\2\u00de\4"+
		"\3\2\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7z\2\2\u00e1\u00e2\7v\2\2\u00e2"+
		"\6\3\2\2\2\u00e3\u00e4\7h\2\2\u00e4\u00e5\7p\2\2\u00e5\b\3\2\2\2\u00e6"+
		"\u00e7\7u\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7f\2\2\u00e9\n\3\2\2\2\u00ea"+
		"\u00eb\7k\2\2\u00eb\u00ec\7h\2\2\u00ec\f\3\2\2\2\u00ed\u00ee\7g\2\2\u00ee"+
		"\u00ef\7n\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1\7g\2\2\u00f1\16\3\2\2\2\u00f2"+
		"\u00f3\7n\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7v\2\2\u00f5\20\3\2\2\2\u00f6"+
		"\u00f7\7e\2\2\u00f7\u00f8\7j\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa\7t\2\2"+
		"\u00fa\22\3\2\2\2\u00fb\u00fc\7d\2\2\u00fc\u00fd\7q\2\2\u00fd\u00fe\7"+
		"q\2\2\u00fe\u00ff\7n\2\2\u00ff\24\3\2\2\2\u0100\u0101\7k\2\2\u0101\u0102"+
		"\7p\2\2\u0102\u0103\7v\2\2\u0103\u0104\7:\2\2\u0104\26\3\2\2\2\u0105\u0106"+
		"\7k\2\2\u0106\u0107\7p\2\2\u0107\u0108\7v\2\2\u0108\u0109\7\63\2\2\u0109"+
		"\u010a\78\2\2\u010a\30\3\2\2\2\u010b\u010c\7k\2\2\u010c\u010d\7p\2\2\u010d"+
		"\u010e\7v\2\2\u010e\u010f\7\65\2\2\u010f\u0110\7\64\2\2\u0110\32\3\2\2"+
		"\2\u0111\u0112\7k\2\2\u0112\u0113\7p\2\2\u0113\u0114\7v\2\2\u0114\u0115"+
		"\78\2\2\u0115\u0116\7\66\2\2\u0116\34\3\2\2\2\u0117\u0118\7h\2\2\u0118"+
		"\u0119\7n\2\2\u0119\u011a\7q\2\2\u011a\u011b\7c\2\2\u011b\u011c\7v\2\2"+
		"\u011c\u011d\7\65\2\2\u011d\u011e\7\64\2\2\u011e\36\3\2\2\2\u011f\u0120"+
		"\7h\2\2\u0120\u0121\7n\2\2\u0121\u0122\7q\2\2\u0122\u0123\7c\2\2\u0123"+
		"\u0124\7v\2\2\u0124\u0125\78\2\2\u0125\u0126\7\66\2\2\u0126 \3\2\2\2\u0127"+
		"\u0128\7u\2\2\u0128\u0129\7v\2\2\u0129\u012a\7t\2\2\u012a\"\3\2\2\2\u012b"+
		"\u012c\7Q\2\2\u012c\u012d\7d\2\2\u012d\u012e\7l\2\2\u012e\u012f\7g\2\2"+
		"\u012f\u0130\7e\2\2\u0130\u0131\7v\2\2\u0131$\3\2\2\2\u0132\u0137\5\'"+
		"\24\2\u0133\u0137\5)\25\2\u0134\u0137\5+\26\2\u0135\u0137\5-\27\2\u0136"+
		"\u0132\3\2\2\2\u0136\u0133\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2"+
		"\2\2\u0137&\3\2\2\2\u0138\u013a\5\61\31\2\u0139\u013b\5/\30\2\u013a\u0139"+
		"\3\2\2\2\u013a\u013b\3\2\2\2\u013b(\3\2\2\2\u013c\u013e\5? \2\u013d\u013f"+
		"\5/\30\2\u013e\u013d\3\2\2\2\u013e\u013f\3\2\2\2\u013f*\3\2\2\2\u0140"+
		"\u0142\5I%\2\u0141\u0143\5/\30\2\u0142\u0141\3\2\2\2\u0142\u0143\3\2\2"+
		"\2\u0143,\3\2\2\2\u0144\u0146\5S*\2\u0145\u0147\5/\30\2\u0146\u0145\3"+
		"\2\2\2\u0146\u0147\3\2\2\2\u0147.\3\2\2\2\u0148\u0149\t\2\2\2\u0149\60"+
		"\3\2\2\2\u014a\u0155\7\62\2\2\u014b\u0152\5\67\34\2\u014c\u014e\5\63\32"+
		"\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0153\3\2\2\2\u014f\u0150"+
		"\5=\37\2\u0150\u0151\5\63\32\2\u0151\u0153\3\2\2\2\u0152\u014d\3\2\2\2"+
		"\u0152\u014f\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u014a\3\2\2\2\u0154\u014b"+
		"\3\2\2\2\u0155\62\3\2\2\2\u0156\u015b\5\65\33\2\u0157\u0159\59\35\2\u0158"+
		"\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\5\65"+
		"\33\2\u015b\u0158\3\2\2\2\u015b\u015c\3\2\2\2\u015c\64\3\2\2\2\u015d\u0160"+
		"\7\62\2\2\u015e\u0160\5\67\34\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2"+
		"\2\u0160\66\3\2\2\2\u0161\u0162\t\3\2\2\u01628\3\2\2\2\u0163\u0165\5;"+
		"\36\2\u0164\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167:\3\2\2\2\u0168\u016b\5\65\33\2\u0169\u016b\7a\2\2"+
		"\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b<\3\2\2\2\u016c\u016e\7"+
		"a\2\2\u016d\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u016d\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170>\3\2\2\2\u0171\u0172\7\62\2\2\u0172\u0173\t\4\2\2"+
		"\u0173\u0174\5A!\2\u0174@\3\2\2\2\u0175\u017a\5C\"\2\u0176\u0178\5E#\2"+
		"\u0177\u0176\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b"+
		"\5C\"\2\u017a\u0177\3\2\2\2\u017a\u017b\3\2\2\2\u017bB\3\2\2\2\u017c\u017d"+
		"\t\5\2\2\u017dD\3\2\2\2\u017e\u0180\5G$\2\u017f\u017e\3\2\2\2\u0180\u0181"+
		"\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182F\3\2\2\2\u0183"+
		"\u0186\5C\"\2\u0184\u0186\7a\2\2\u0185\u0183\3\2\2\2\u0185\u0184\3\2\2"+
		"\2\u0186H\3\2\2\2\u0187\u0189\7\62\2\2\u0188\u018a\5=\37\2\u0189\u0188"+
		"\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\5K&\2\u018c"+
		"J\3\2\2\2\u018d\u0192\5M\'\2\u018e\u0190\5O(\2\u018f\u018e\3\2\2\2\u018f"+
		"\u0190\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\5M\'\2\u0192\u018f\3\2"+
		"\2\2\u0192\u0193\3\2\2\2\u0193L\3\2\2\2\u0194\u0195\t\6\2\2\u0195N\3\2"+
		"\2\2\u0196\u0198\5Q)\2\u0197\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u0197"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019aP\3\2\2\2\u019b\u019e\5M\'\2\u019c\u019e"+
		"\7a\2\2\u019d\u019b\3\2\2\2\u019d\u019c\3\2\2\2\u019eR\3\2\2\2\u019f\u01a0"+
		"\7\62\2\2\u01a0\u01a1\t\7\2\2\u01a1\u01a2\5U+\2\u01a2T\3\2\2\2\u01a3\u01a8"+
		"\5W,\2\u01a4\u01a6\5Y-\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"\u01a7\3\2\2\2\u01a7\u01a9\5W,\2\u01a8\u01a5\3\2\2\2\u01a8\u01a9\3\2\2"+
		"\2\u01a9V\3\2\2\2\u01aa\u01ab\t\b\2\2\u01abX\3\2\2\2\u01ac\u01ae\5[.\2"+
		"\u01ad\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0"+
		"\3\2\2\2\u01b0Z\3\2\2\2\u01b1\u01b4\5W,\2\u01b2\u01b4\7a\2\2\u01b3\u01b1"+
		"\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4\\\3\2\2\2\u01b5\u01b8\5_\60\2\u01b6"+
		"\u01b8\5k\66\2\u01b7\u01b5\3\2\2\2\u01b7\u01b6\3\2\2\2\u01b8^\3\2\2\2"+
		"\u01b9\u01ba\5\63\32\2\u01ba\u01bc\7\60\2\2\u01bb\u01bd\5\63\32\2\u01bc"+
		"\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf\3\2\2\2\u01be\u01c0\5a"+
		"\61\2\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c2\3\2\2\2\u01c1"+
		"\u01c3\5i\65\2\u01c2\u01c1\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01d5\3\2"+
		"\2\2\u01c4\u01c5\7\60\2\2\u01c5\u01c7\5\63\32\2\u01c6\u01c8\5a\61\2\u01c7"+
		"\u01c6\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01cb\5i"+
		"\65\2\u01ca\u01c9\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01d5\3\2\2\2\u01cc"+
		"\u01cd\5\63\32\2\u01cd\u01cf\5a\61\2\u01ce\u01d0\5i\65\2\u01cf\u01ce\3"+
		"\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d5\3\2\2\2\u01d1\u01d2\5\63\32\2\u01d2"+
		"\u01d3\5i\65\2\u01d3\u01d5\3\2\2\2\u01d4\u01b9\3\2\2\2\u01d4\u01c4\3\2"+
		"\2\2\u01d4\u01cc\3\2\2\2\u01d4\u01d1\3\2\2\2\u01d5`\3\2\2\2\u01d6\u01d7"+
		"\5c\62\2\u01d7\u01d8\5e\63\2\u01d8b\3\2\2\2\u01d9\u01da\t\t\2\2\u01da"+
		"d\3\2\2\2\u01db\u01dd\5g\64\2\u01dc\u01db\3\2\2\2\u01dc\u01dd\3\2\2\2"+
		"\u01dd\u01de\3\2\2\2\u01de\u01df\5\63\32\2\u01dff\3\2\2\2\u01e0\u01e1"+
		"\t\n\2\2\u01e1h\3\2\2\2\u01e2\u01e3\t\13\2\2\u01e3j\3\2\2\2\u01e4\u01e5"+
		"\5m\67\2\u01e5\u01e7\5o8\2\u01e6\u01e8\5i\65\2\u01e7\u01e6\3\2\2\2\u01e7"+
		"\u01e8\3\2\2\2\u01e8l\3\2\2\2\u01e9\u01eb\5? \2\u01ea\u01ec\7\60\2\2\u01eb"+
		"\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01f5\3\2\2\2\u01ed\u01ee\7\62"+
		"\2\2\u01ee\u01f0\t\4\2\2\u01ef\u01f1\5A!\2\u01f0\u01ef\3\2\2\2\u01f0\u01f1"+
		"\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f3\7\60\2\2\u01f3\u01f5\5A!\2\u01f4"+
		"\u01e9\3\2\2\2\u01f4\u01ed\3\2\2\2\u01f5n\3\2\2\2\u01f6\u01f7\5q9\2\u01f7"+
		"\u01f8\5e\63\2\u01f8p\3\2\2\2\u01f9\u01fa\t\f\2\2\u01far\3\2\2\2\u01fb"+
		"\u01fc\7v\2\2\u01fc\u01fd\7t\2\2\u01fd\u01fe\7w\2\2\u01fe\u0205\7g\2\2"+
		"\u01ff\u0200\7h\2\2\u0200\u0201\7c\2\2\u0201\u0202\7n\2\2\u0202\u0203"+
		"\7u\2\2\u0203\u0205\7g\2\2\u0204\u01fb\3\2\2\2\u0204\u01ff\3\2\2\2\u0205"+
		"t\3\2\2\2\u0206\u0207\7)\2\2\u0207\u0208\5w<\2\u0208\u0209\7)\2\2\u0209"+
		"\u020f\3\2\2\2\u020a\u020b\7)\2\2\u020b\u020c\5\177@\2\u020c\u020d\7)"+
		"\2\2\u020d\u020f\3\2\2\2\u020e\u0206\3\2\2\2\u020e\u020a\3\2\2\2\u020f"+
		"v\3\2\2\2\u0210\u0211\n\r\2\2\u0211x\3\2\2\2\u0212\u0214\7$\2\2\u0213"+
		"\u0215\5{>\2\u0214\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\3\2\2"+
		"\2\u0216\u0217\7$\2\2\u0217z\3\2\2\2\u0218\u021a\5}?\2\u0219\u0218\3\2"+
		"\2\2\u021a\u021b\3\2\2\2\u021b\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c"+
		"|\3\2\2\2\u021d\u0220\n\16\2\2\u021e\u0220\5\177@\2\u021f\u021d\3\2\2"+
		"\2\u021f\u021e\3\2\2\2\u0220~\3\2\2\2\u0221\u0222\7^\2\2\u0222\u0226\t"+
		"\17\2\2\u0223\u0226\5\u0081A\2\u0224\u0226\5\u0085C\2\u0225\u0221\3\2"+
		"\2\2\u0225\u0223\3\2\2\2\u0225\u0224\3\2\2\2\u0226\u0080\3\2\2\2\u0227"+
		"\u0228\7^\2\2\u0228\u0233\5M\'\2\u0229\u022a\7^\2\2\u022a\u022b\5M\'\2"+
		"\u022b\u022c\5M\'\2\u022c\u0233\3\2\2\2\u022d\u022e\7^\2\2\u022e\u022f"+
		"\5\u0083B\2\u022f\u0230\5M\'\2\u0230\u0231\5M\'\2\u0231\u0233\3\2\2\2"+
		"\u0232\u0227\3\2\2\2\u0232\u0229\3\2\2\2\u0232\u022d\3\2\2\2\u0233\u0082"+
		"\3\2\2\2\u0234\u0235\t\20\2\2\u0235\u0084\3\2\2\2\u0236\u0238\7^\2\2\u0237"+
		"\u0239\7w\2\2\u0238\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u0238\3\2"+
		"\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\5C\"\2\u023d"+
		"\u023e\5C\"\2\u023e\u023f\5C\"\2\u023f\u0240\5C\"\2\u0240\u0086\3\2\2"+
		"\2\u0241\u0242\7p\2\2\u0242\u0243\7w\2\2\u0243\u0244\7n\2\2\u0244\u0245"+
		"\7n\2\2\u0245\u0088\3\2\2\2\u0246\u0247\7*\2\2\u0247\u008a\3\2\2\2\u0248"+
		"\u0249\7+\2\2\u0249\u008c\3\2\2\2\u024a\u024b\7}\2\2\u024b\u008e\3\2\2"+
		"\2\u024c\u024d\7\177\2\2\u024d\u0090\3\2\2\2\u024e\u024f\7]\2\2\u024f"+
		"\u0092\3\2\2\2\u0250\u0251\7_\2\2\u0251\u0094\3\2\2\2\u0252\u0253\7=\2"+
		"\2\u0253\u0096\3\2\2\2\u0254\u0255\7\60\2\2\u0255\u0098\3\2\2\2\u0256"+
		"\u0257\7&\2\2\u0257\u009a\3\2\2\2\u0258\u0259\7.\2\2\u0259\u009c\3\2\2"+
		"\2\u025a\u025b\7/\2\2\u025b\u025c\7@\2\2\u025c\u009e\3\2\2\2\u025d\u025e"+
		"\7?\2\2\u025e\u00a0\3\2\2\2\u025f\u0260\7@\2\2\u0260\u00a2\3\2\2\2\u0261"+
		"\u0262\7>\2\2\u0262\u00a4\3\2\2\2\u0263\u0264\7#\2\2\u0264\u00a6\3\2\2"+
		"\2\u0265\u0266\7\u0080\2\2\u0266\u00a8\3\2\2\2\u0267\u0268\7A\2\2\u0268"+
		"\u00aa\3\2\2\2\u0269\u026a\7<\2\2\u026a\u00ac\3\2\2\2\u026b\u026c\7<\2"+
		"\2\u026c\u026d\7<\2\2\u026d\u00ae\3\2\2\2\u026e\u026f\7?\2\2\u026f\u0270"+
		"\7?\2\2\u0270\u00b0\3\2\2\2\u0271\u0272\7>\2\2\u0272\u0273\7?\2\2\u0273"+
		"\u00b2\3\2\2\2\u0274\u0275\7@\2\2\u0275\u0276\7?\2\2\u0276\u00b4\3\2\2"+
		"\2\u0277\u0278\7#\2\2\u0278\u0279\7?\2\2\u0279\u00b6\3\2\2\2\u027a\u027b"+
		"\7(\2\2\u027b\u027c\7(\2\2\u027c\u00b8\3\2\2\2\u027d\u027e\7~\2\2\u027e"+
		"\u027f\7~\2\2\u027f\u00ba\3\2\2\2\u0280\u0281\7-\2\2\u0281\u0282\7-\2"+
		"\2\u0282\u00bc\3\2\2\2\u0283\u0284\7/\2\2\u0284\u0285\7/\2\2\u0285\u00be"+
		"\3\2\2\2\u0286\u0287\7-\2\2\u0287\u00c0\3\2\2\2\u0288\u0289\7/\2\2\u0289"+
		"\u00c2\3\2\2\2\u028a\u028b\7,\2\2\u028b\u00c4\3\2\2\2\u028c\u028d\7\61"+
		"\2\2\u028d\u00c6\3\2\2\2\u028e\u028f\7(\2\2\u028f\u00c8\3\2\2\2\u0290"+
		"\u0291\7~\2\2\u0291\u00ca\3\2\2\2\u0292\u0293\7`\2\2\u0293\u00cc\3\2\2"+
		"\2\u0294\u0295\7\'\2\2\u0295\u00ce\3\2\2\2\u0296\u029a\5\u00d1i\2\u0297"+
		"\u0299\5\u00d3j\2\u0298\u0297\3\2\2\2\u0299\u029c\3\2\2\2\u029a\u0298"+
		"\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u00d0\3\2\2\2\u029c\u029a\3\2\2\2\u029d"+
		"\u02a4\t\21\2\2\u029e\u029f\n\22\2\2\u029f\u02a4\6i\2\2\u02a0\u02a1\t"+
		"\23\2\2\u02a1\u02a2\t\24\2\2\u02a2\u02a4\6i\3\2\u02a3\u029d\3\2\2\2\u02a3"+
		"\u029e\3\2\2\2\u02a3\u02a0\3\2\2\2\u02a4\u00d2\3\2\2\2\u02a5\u02ac\t\25"+
		"\2\2\u02a6\u02a7\n\22\2\2\u02a7\u02ac\6j\4\2\u02a8\u02a9\t\23\2\2\u02a9"+
		"\u02aa\t\24\2\2\u02aa\u02ac\6j\5\2\u02ab\u02a5\3\2\2\2\u02ab\u02a6\3\2"+
		"\2\2\u02ab\u02a8\3\2\2\2\u02ac\u00d4\3\2\2\2\u02ad\u02af\t\26\2\2\u02ae"+
		"\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2"+
		"\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b3\bk\2\2\u02b3\u00d6\3\2\2\2\u02b4"+
		"\u02b5\7\61\2\2\u02b5\u02b6\7,\2\2\u02b6\u02ba\3\2\2\2\u02b7\u02b9\13"+
		"\2\2\2\u02b8\u02b7\3\2\2\2\u02b9\u02bc\3\2\2\2\u02ba\u02bb\3\2\2\2\u02ba"+
		"\u02b8\3\2\2\2\u02bb\u02bd\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bd\u02be\7,"+
		"\2\2\u02be\u02bf\7\61\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\bl\3\2\u02c1"+
		"\u00d8\3\2\2\2\u02c2\u02c3\7\61\2\2\u02c3\u02c4\7\61\2\2\u02c4\u02c8\3"+
		"\2\2\2\u02c5\u02c7\n\27\2\2\u02c6\u02c5\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8"+
		"\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02cb\3\2\2\2\u02ca\u02c8\3\2"+
		"\2\2\u02cb\u02cc\bm\3\2\u02cc\u00da\3\2\2\29\2\u0136\u013a\u013e\u0142"+
		"\u0146\u014d\u0152\u0154\u0158\u015b\u015f\u0166\u016a\u016f\u0177\u017a"+
		"\u0181\u0185\u0189\u018f\u0192\u0199\u019d\u01a5\u01a8\u01af\u01b3\u01b7"+
		"\u01bc\u01bf\u01c2\u01c7\u01ca\u01cf\u01d4\u01dc\u01e7\u01eb\u01f0\u01f4"+
		"\u0204\u020e\u0214\u021b\u021f\u0225\u0232\u023a\u029a\u02a3\u02ab\u02b0"+
		"\u02ba\u02c8\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}