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
		CTX=1, FN=2, STD=3, IntegerLiteral=4, FloatingPointLiteral=5, BooleanLiteral=6, 
		CharacterLiteral=7, StringLiteral=8, NullLiteral=9, LPAREN=10, RPAREN=11, 
		LBRACE=12, RBRACE=13, LBRACK=14, RBRACK=15, SEMI=16, DOT=17, COMMA=18, 
		ASSIGN=19, GT=20, LT=21, BANG=22, TILDE=23, QUESTION=24, COLON=25, COLONCOLON=26, 
		EQUAL=27, LE=28, GE=29, NOTEQUAL=30, AND=31, OR=32, INC=33, DEC=34, ADD=35, 
		SUB=36, MUL=37, DIV=38, BITAND=39, BITOR=40, CARET=41, MOD=42, Identifier=43, 
		WS=44, COMMENT=45, LINE_COMMENT=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CTX", "FN", "STD", "IntegerLiteral", "DecimalIntegerLiteral", "HexIntegerLiteral", 
		"OctalIntegerLiteral", "BinaryIntegerLiteral", "IntegerTypeSuffix", "DecimalNumeral", 
		"Digits", "Digit", "NonZeroDigit", "DigitsAndUnderscores", "DigitOrUnderscore", 
		"Underscores", "HexNumeral", "HexDigits", "HexDigit", "HexDigitsAndUnderscores", 
		"HexDigitOrUnderscore", "OctalNumeral", "OctalDigits", "OctalDigit", "OctalDigitsAndUnderscores", 
		"OctalDigitOrUnderscore", "BinaryNumeral", "BinaryDigits", "BinaryDigit", 
		"BinaryDigitsAndUnderscores", "BinaryDigitOrUnderscore", "FloatingPointLiteral", 
		"DecimalFloatingPointLiteral", "ExponentPart", "ExponentIndicator", "SignedInteger", 
		"Sign", "FloatTypeSuffix", "HexadecimalFloatingPointLiteral", "HexSignificand", 
		"BinaryExponent", "BinaryExponentIndicator", "BooleanLiteral", "CharacterLiteral", 
		"SingleCharacter", "StringLiteral", "StringCharacters", "StringCharacter", 
		"EscapeSequence", "OctalEscape", "ZeroToThree", "UnicodeEscape", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "DOT", 
		"COMMA", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "COLONCOLON", 
		"EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
		"MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "Identifier", "Letter", 
		"LetterOrDigit", "WS", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'ctx'", "'fn'", "'std'", null, null, null, null, null, "'null'", 
		"'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", "','", "'='", 
		"'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'::'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
		"'|'", "'^'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CTX", "FN", "STD", "IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", 
		"CharacterLiteral", "StringLiteral", "NullLiteral", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "DOT", "COMMA", "ASSIGN", 
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
		case 87:
			return Letter_sempred((RuleContext)_localctx, predIndex);
		case 88:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u025c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5\u00cb\n\5\3\6\3\6"+
		"\5\6\u00cf\n\6\3\7\3\7\5\7\u00d3\n\7\3\b\3\b\5\b\u00d7\n\b\3\t\3\t\5\t"+
		"\u00db\n\t\3\n\3\n\3\13\3\13\3\13\5\13\u00e2\n\13\3\13\3\13\3\13\5\13"+
		"\u00e7\n\13\5\13\u00e9\n\13\3\f\3\f\5\f\u00ed\n\f\3\f\5\f\u00f0\n\f\3"+
		"\r\3\r\5\r\u00f4\n\r\3\16\3\16\3\17\6\17\u00f9\n\17\r\17\16\17\u00fa\3"+
		"\20\3\20\5\20\u00ff\n\20\3\21\6\21\u0102\n\21\r\21\16\21\u0103\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\5\23\u010c\n\23\3\23\5\23\u010f\n\23\3\24\3\24"+
		"\3\25\6\25\u0114\n\25\r\25\16\25\u0115\3\26\3\26\5\26\u011a\n\26\3\27"+
		"\3\27\5\27\u011e\n\27\3\27\3\27\3\30\3\30\5\30\u0124\n\30\3\30\5\30\u0127"+
		"\n\30\3\31\3\31\3\32\6\32\u012c\n\32\r\32\16\32\u012d\3\33\3\33\5\33\u0132"+
		"\n\33\3\34\3\34\3\34\3\34\3\35\3\35\5\35\u013a\n\35\3\35\5\35\u013d\n"+
		"\35\3\36\3\36\3\37\6\37\u0142\n\37\r\37\16\37\u0143\3 \3 \5 \u0148\n "+
		"\3!\3!\5!\u014c\n!\3\"\3\"\3\"\5\"\u0151\n\"\3\"\5\"\u0154\n\"\3\"\5\""+
		"\u0157\n\"\3\"\3\"\3\"\5\"\u015c\n\"\3\"\5\"\u015f\n\"\3\"\3\"\3\"\5\""+
		"\u0164\n\"\3\"\3\"\3\"\5\"\u0169\n\"\3#\3#\3#\3$\3$\3%\5%\u0171\n%\3%"+
		"\3%\3&\3&\3\'\3\'\3(\3(\3(\5(\u017c\n(\3)\3)\5)\u0180\n)\3)\3)\3)\5)\u0185"+
		"\n)\3)\3)\5)\u0189\n)\3*\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0199"+
		"\n,\3-\3-\3-\3-\3-\3-\3-\3-\5-\u01a3\n-\3.\3.\3/\3/\5/\u01a9\n/\3/\3/"+
		"\3\60\6\60\u01ae\n\60\r\60\16\60\u01af\3\61\3\61\5\61\u01b4\n\61\3\62"+
		"\3\62\3\62\3\62\5\62\u01ba\n\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\5\63\u01c7\n\63\3\64\3\64\3\65\3\65\6\65\u01cd\n\65\r"+
		"\65\16\65\u01ce\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3"+
		"B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3G\3H\3H\3H\3I\3I\3I\3J\3J\3J\3K\3K\3"+
		"K\3L\3L\3L\3M\3M\3M\3N\3N\3N\3O\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3"+
		"U\3U\3V\3V\3W\3W\3X\3X\7X\u0228\nX\fX\16X\u022b\13X\3Y\3Y\3Y\3Y\3Y\3Y"+
		"\5Y\u0233\nY\3Z\3Z\3Z\3Z\3Z\3Z\5Z\u023b\nZ\3[\6[\u023e\n[\r[\16[\u023f"+
		"\3[\3[\3\\\3\\\3\\\3\\\7\\\u0248\n\\\f\\\16\\\u024b\13\\\3\\\3\\\3\\\3"+
		"\\\3\\\3]\3]\3]\3]\7]\u0256\n]\f]\16]\u0259\13]\3]\3]\3\u0249\2^\3\3\5"+
		"\4\7\5\t\6\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2"+
		"%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\7C\2E\2G\2I\2K\2"+
		"M\2O\2Q\2S\2U\2W\bY\t[\2]\n_\2a\2c\2e\2g\2i\2k\13m\fo\rq\16s\17u\20w\21"+
		"y\22{\23}\24\177\25\u0081\26\u0083\27\u0085\30\u0087\31\u0089\32\u008b"+
		"\33\u008d\34\u008f\35\u0091\36\u0093\37\u0095 \u0097!\u0099\"\u009b#\u009d"+
		"$\u009f%\u00a1&\u00a3\'\u00a5(\u00a7)\u00a9*\u00ab+\u00ad,\u00af-\u00b1"+
		"\2\u00b3\2\u00b5.\u00b7/\u00b9\60\3\2\30\4\2NNnn\3\2\63;\4\2ZZzz\5\2\62"+
		";CHch\3\2\629\4\2DDdd\3\2\62\63\4\2GGgg\4\2--//\6\2FFHHffhh\4\2RRrr\6"+
		"\2\f\f\17\17))^^\6\2\f\f\17\17$$^^\n\2$$))^^ddhhppttvv\3\2\62\65\6\2&"+
		"&C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802\udc01\3\2\udc02\ue001\7\2&"+
		"&\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\2\u026b\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2A\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2]\3"+
		"\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2"+
		"\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3"+
		"\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2"+
		"\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093"+
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2"+
		"\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5"+
		"\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2"+
		"\2\2\u00af\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\3\u00bb"+
		"\3\2\2\2\5\u00bf\3\2\2\2\7\u00c2\3\2\2\2\t\u00ca\3\2\2\2\13\u00cc\3\2"+
		"\2\2\r\u00d0\3\2\2\2\17\u00d4\3\2\2\2\21\u00d8\3\2\2\2\23\u00dc\3\2\2"+
		"\2\25\u00e8\3\2\2\2\27\u00ea\3\2\2\2\31\u00f3\3\2\2\2\33\u00f5\3\2\2\2"+
		"\35\u00f8\3\2\2\2\37\u00fe\3\2\2\2!\u0101\3\2\2\2#\u0105\3\2\2\2%\u0109"+
		"\3\2\2\2\'\u0110\3\2\2\2)\u0113\3\2\2\2+\u0119\3\2\2\2-\u011b\3\2\2\2"+
		"/\u0121\3\2\2\2\61\u0128\3\2\2\2\63\u012b\3\2\2\2\65\u0131\3\2\2\2\67"+
		"\u0133\3\2\2\29\u0137\3\2\2\2;\u013e\3\2\2\2=\u0141\3\2\2\2?\u0147\3\2"+
		"\2\2A\u014b\3\2\2\2C\u0168\3\2\2\2E\u016a\3\2\2\2G\u016d\3\2\2\2I\u0170"+
		"\3\2\2\2K\u0174\3\2\2\2M\u0176\3\2\2\2O\u0178\3\2\2\2Q\u0188\3\2\2\2S"+
		"\u018a\3\2\2\2U\u018d\3\2\2\2W\u0198\3\2\2\2Y\u01a2\3\2\2\2[\u01a4\3\2"+
		"\2\2]\u01a6\3\2\2\2_\u01ad\3\2\2\2a\u01b3\3\2\2\2c\u01b9\3\2\2\2e\u01c6"+
		"\3\2\2\2g\u01c8\3\2\2\2i\u01ca\3\2\2\2k\u01d5\3\2\2\2m\u01da\3\2\2\2o"+
		"\u01dc\3\2\2\2q\u01de\3\2\2\2s\u01e0\3\2\2\2u\u01e2\3\2\2\2w\u01e4\3\2"+
		"\2\2y\u01e6\3\2\2\2{\u01e8\3\2\2\2}\u01ea\3\2\2\2\177\u01ec\3\2\2\2\u0081"+
		"\u01ee\3\2\2\2\u0083\u01f0\3\2\2\2\u0085\u01f2\3\2\2\2\u0087\u01f4\3\2"+
		"\2\2\u0089\u01f6\3\2\2\2\u008b\u01f8\3\2\2\2\u008d\u01fa\3\2\2\2\u008f"+
		"\u01fd\3\2\2\2\u0091\u0200\3\2\2\2\u0093\u0203\3\2\2\2\u0095\u0206\3\2"+
		"\2\2\u0097\u0209\3\2\2\2\u0099\u020c\3\2\2\2\u009b\u020f\3\2\2\2\u009d"+
		"\u0212\3\2\2\2\u009f\u0215\3\2\2\2\u00a1\u0217\3\2\2\2\u00a3\u0219\3\2"+
		"\2\2\u00a5\u021b\3\2\2\2\u00a7\u021d\3\2\2\2\u00a9\u021f\3\2\2\2\u00ab"+
		"\u0221\3\2\2\2\u00ad\u0223\3\2\2\2\u00af\u0225\3\2\2\2\u00b1\u0232\3\2"+
		"\2\2\u00b3\u023a\3\2\2\2\u00b5\u023d\3\2\2\2\u00b7\u0243\3\2\2\2\u00b9"+
		"\u0251\3\2\2\2\u00bb\u00bc\7e\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7z\2"+
		"\2\u00be\4\3\2\2\2\u00bf\u00c0\7h\2\2\u00c0\u00c1\7p\2\2\u00c1\6\3\2\2"+
		"\2\u00c2\u00c3\7u\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7f\2\2\u00c5\b\3"+
		"\2\2\2\u00c6\u00cb\5\13\6\2\u00c7\u00cb\5\r\7\2\u00c8\u00cb\5\17\b\2\u00c9"+
		"\u00cb\5\21\t\2\u00ca\u00c6\3\2\2\2\u00ca\u00c7\3\2\2\2\u00ca\u00c8\3"+
		"\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\n\3\2\2\2\u00cc\u00ce\5\25\13\2\u00cd"+
		"\u00cf\5\23\n\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\f\3\2\2"+
		"\2\u00d0\u00d2\5#\22\2\u00d1\u00d3\5\23\n\2\u00d2\u00d1\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\16\3\2\2\2\u00d4\u00d6\5-\27\2\u00d5\u00d7\5\23\n"+
		"\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\20\3\2\2\2\u00d8\u00da"+
		"\5\67\34\2\u00d9\u00db\5\23\n\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2"+
		"\2\u00db\22\3\2\2\2\u00dc\u00dd\t\2\2\2\u00dd\24\3\2\2\2\u00de\u00e9\7"+
		"\62\2\2\u00df\u00e6\5\33\16\2\u00e0\u00e2\5\27\f\2\u00e1\u00e0\3\2\2\2"+
		"\u00e1\u00e2\3\2\2\2\u00e2\u00e7\3\2\2\2\u00e3\u00e4\5!\21\2\u00e4\u00e5"+
		"\5\27\f\2\u00e5\u00e7\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e3\3\2\2\2"+
		"\u00e7\u00e9\3\2\2\2\u00e8\u00de\3\2\2\2\u00e8\u00df\3\2\2\2\u00e9\26"+
		"\3\2\2\2\u00ea\u00ef\5\31\r\2\u00eb\u00ed\5\35\17\2\u00ec\u00eb\3\2\2"+
		"\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\5\31\r\2\u00ef"+
		"\u00ec\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\30\3\2\2\2\u00f1\u00f4\7\62\2"+
		"\2\u00f2\u00f4\5\33\16\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\32\3\2\2\2\u00f5\u00f6\t\3\2\2\u00f6\34\3\2\2\2\u00f7\u00f9\5\37\20\2"+
		"\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\36\3\2\2\2\u00fc\u00ff\5\31\r\2\u00fd\u00ff\7a\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff \3\2\2\2\u0100\u0102\7a\2\2\u0101"+
		"\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\"\3\2\2\2\u0105\u0106\7\62\2\2\u0106\u0107\t\4\2\2\u0107\u0108"+
		"\5%\23\2\u0108$\3\2\2\2\u0109\u010e\5\'\24\2\u010a\u010c\5)\25\2\u010b"+
		"\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f\5\'"+
		"\24\2\u010e\u010b\3\2\2\2\u010e\u010f\3\2\2\2\u010f&\3\2\2\2\u0110\u0111"+
		"\t\5\2\2\u0111(\3\2\2\2\u0112\u0114\5+\26\2\u0113\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116*\3\2\2\2"+
		"\u0117\u011a\5\'\24\2\u0118\u011a\7a\2\2\u0119\u0117\3\2\2\2\u0119\u0118"+
		"\3\2\2\2\u011a,\3\2\2\2\u011b\u011d\7\62\2\2\u011c\u011e\5!\21\2\u011d"+
		"\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\5/"+
		"\30\2\u0120.\3\2\2\2\u0121\u0126\5\61\31\2\u0122\u0124\5\63\32\2\u0123"+
		"\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\5\61"+
		"\31\2\u0126\u0123\3\2\2\2\u0126\u0127\3\2\2\2\u0127\60\3\2\2\2\u0128\u0129"+
		"\t\6\2\2\u0129\62\3\2\2\2\u012a\u012c\5\65\33\2\u012b\u012a\3\2\2\2\u012c"+
		"\u012d\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\64\3\2\2"+
		"\2\u012f\u0132\5\61\31\2\u0130\u0132\7a\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0130\3\2\2\2\u0132\66\3\2\2\2\u0133\u0134\7\62\2\2\u0134\u0135\t\7\2"+
		"\2\u0135\u0136\59\35\2\u01368\3\2\2\2\u0137\u013c\5;\36\2\u0138\u013a"+
		"\5=\37\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013d\5;\36\2\u013c\u0139\3\2\2\2\u013c\u013d\3\2\2\2\u013d:\3\2\2\2"+
		"\u013e\u013f\t\b\2\2\u013f<\3\2\2\2\u0140\u0142\5? \2\u0141\u0140\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		">\3\2\2\2\u0145\u0148\5;\36\2\u0146\u0148\7a\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0146\3\2\2\2\u0148@\3\2\2\2\u0149\u014c\5C\"\2\u014a\u014c\5O(\2\u014b"+
		"\u0149\3\2\2\2\u014b\u014a\3\2\2\2\u014cB\3\2\2\2\u014d\u014e\5\27\f\2"+
		"\u014e\u0150\7\60\2\2\u014f\u0151\5\27\f\2\u0150\u014f\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0154\5E#\2\u0153\u0152\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0157\5M\'\2\u0156\u0155\3\2"+
		"\2\2\u0156\u0157\3\2\2\2\u0157\u0169\3\2\2\2\u0158\u0159\7\60\2\2\u0159"+
		"\u015b\5\27\f\2\u015a\u015c\5E#\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c\u015e\3\2\2\2\u015d\u015f\5M\'\2\u015e\u015d\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0169\3\2\2\2\u0160\u0161\5\27\f\2\u0161\u0163\5"+
		"E#\2\u0162\u0164\5M\'\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\u0169\3\2\2\2\u0165\u0166\5\27\f\2\u0166\u0167\5M\'\2\u0167\u0169\3\2"+
		"\2\2\u0168\u014d\3\2\2\2\u0168\u0158\3\2\2\2\u0168\u0160\3\2\2\2\u0168"+
		"\u0165\3\2\2\2\u0169D\3\2\2\2\u016a\u016b\5G$\2\u016b\u016c\5I%\2\u016c"+
		"F\3\2\2\2\u016d\u016e\t\t\2\2\u016eH\3\2\2\2\u016f\u0171\5K&\2\u0170\u016f"+
		"\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\5\27\f\2"+
		"\u0173J\3\2\2\2\u0174\u0175\t\n\2\2\u0175L\3\2\2\2\u0176\u0177\t\13\2"+
		"\2\u0177N\3\2\2\2\u0178\u0179\5Q)\2\u0179\u017b\5S*\2\u017a\u017c\5M\'"+
		"\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017cP\3\2\2\2\u017d\u017f"+
		"\5#\22\2\u017e\u0180\7\60\2\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2\2"+
		"\u0180\u0189\3\2\2\2\u0181\u0182\7\62\2\2\u0182\u0184\t\4\2\2\u0183\u0185"+
		"\5%\23\2\u0184\u0183\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186"+
		"\u0187\7\60\2\2\u0187\u0189\5%\23\2\u0188\u017d\3\2\2\2\u0188\u0181\3"+
		"\2\2\2\u0189R\3\2\2\2\u018a\u018b\5U+\2\u018b\u018c\5I%\2\u018cT\3\2\2"+
		"\2\u018d\u018e\t\f\2\2\u018eV\3\2\2\2\u018f\u0190\7v\2\2\u0190\u0191\7"+
		"t\2\2\u0191\u0192\7w\2\2\u0192\u0199\7g\2\2\u0193\u0194\7h\2\2\u0194\u0195"+
		"\7c\2\2\u0195\u0196\7n\2\2\u0196\u0197\7u\2\2\u0197\u0199\7g\2\2\u0198"+
		"\u018f\3\2\2\2\u0198\u0193\3\2\2\2\u0199X\3\2\2\2\u019a\u019b\7)\2\2\u019b"+
		"\u019c\5[.\2\u019c\u019d\7)\2\2\u019d\u01a3\3\2\2\2\u019e\u019f\7)\2\2"+
		"\u019f\u01a0\5c\62\2\u01a0\u01a1\7)\2\2\u01a1\u01a3\3\2\2\2\u01a2\u019a"+
		"\3\2\2\2\u01a2\u019e\3\2\2\2\u01a3Z\3\2\2\2\u01a4\u01a5\n\r\2\2\u01a5"+
		"\\\3\2\2\2\u01a6\u01a8\7$\2\2\u01a7\u01a9\5_\60\2\u01a8\u01a7\3\2\2\2"+
		"\u01a8\u01a9\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\7$\2\2\u01ab^\3\2"+
		"\2\2\u01ac\u01ae\5a\61\2\u01ad\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af"+
		"\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0`\3\2\2\2\u01b1\u01b4\n\16\2\2"+
		"\u01b2\u01b4\5c\62\2\u01b3\u01b1\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4b\3"+
		"\2\2\2\u01b5\u01b6\7^\2\2\u01b6\u01ba\t\17\2\2\u01b7\u01ba\5e\63\2\u01b8"+
		"\u01ba\5i\65\2\u01b9\u01b5\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01b8\3\2"+
		"\2\2\u01bad\3\2\2\2\u01bb\u01bc\7^\2\2\u01bc\u01c7\5\61\31\2\u01bd\u01be"+
		"\7^\2\2\u01be\u01bf\5\61\31\2\u01bf\u01c0\5\61\31\2\u01c0\u01c7\3\2\2"+
		"\2\u01c1\u01c2\7^\2\2\u01c2\u01c3\5g\64\2\u01c3\u01c4\5\61\31\2\u01c4"+
		"\u01c5\5\61\31\2\u01c5\u01c7\3\2\2\2\u01c6\u01bb\3\2\2\2\u01c6\u01bd\3"+
		"\2\2\2\u01c6\u01c1\3\2\2\2\u01c7f\3\2\2\2\u01c8\u01c9\t\20\2\2\u01c9h"+
		"\3\2\2\2\u01ca\u01cc\7^\2\2\u01cb\u01cd\7w\2\2\u01cc\u01cb\3\2\2\2\u01cd"+
		"\u01ce\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\3\2"+
		"\2\2\u01d0\u01d1\5\'\24\2\u01d1\u01d2\5\'\24\2\u01d2\u01d3\5\'\24\2\u01d3"+
		"\u01d4\5\'\24\2\u01d4j\3\2\2\2\u01d5\u01d6\7p\2\2\u01d6\u01d7\7w\2\2\u01d7"+
		"\u01d8\7n\2\2\u01d8\u01d9\7n\2\2\u01d9l\3\2\2\2\u01da\u01db\7*\2\2\u01db"+
		"n\3\2\2\2\u01dc\u01dd\7+\2\2\u01ddp\3\2\2\2\u01de\u01df\7}\2\2\u01dfr"+
		"\3\2\2\2\u01e0\u01e1\7\177\2\2\u01e1t\3\2\2\2\u01e2\u01e3\7]\2\2\u01e3"+
		"v\3\2\2\2\u01e4\u01e5\7_\2\2\u01e5x\3\2\2\2\u01e6\u01e7\7=\2\2\u01e7z"+
		"\3\2\2\2\u01e8\u01e9\7\60\2\2\u01e9|\3\2\2\2\u01ea\u01eb\7.\2\2\u01eb"+
		"~\3\2\2\2\u01ec\u01ed\7?\2\2\u01ed\u0080\3\2\2\2\u01ee\u01ef\7@\2\2\u01ef"+
		"\u0082\3\2\2\2\u01f0\u01f1\7>\2\2\u01f1\u0084\3\2\2\2\u01f2\u01f3\7#\2"+
		"\2\u01f3\u0086\3\2\2\2\u01f4\u01f5\7\u0080\2\2\u01f5\u0088\3\2\2\2\u01f6"+
		"\u01f7\7A\2\2\u01f7\u008a\3\2\2\2\u01f8\u01f9\7<\2\2\u01f9\u008c\3\2\2"+
		"\2\u01fa\u01fb\7<\2\2\u01fb\u01fc\7<\2\2\u01fc\u008e\3\2\2\2\u01fd\u01fe"+
		"\7?\2\2\u01fe\u01ff\7?\2\2\u01ff\u0090\3\2\2\2\u0200\u0201\7>\2\2\u0201"+
		"\u0202\7?\2\2\u0202\u0092\3\2\2\2\u0203\u0204\7@\2\2\u0204\u0205\7?\2"+
		"\2\u0205\u0094\3\2\2\2\u0206\u0207\7#\2\2\u0207\u0208\7?\2\2\u0208\u0096"+
		"\3\2\2\2\u0209\u020a\7(\2\2\u020a\u020b\7(\2\2\u020b\u0098\3\2\2\2\u020c"+
		"\u020d\7~\2\2\u020d\u020e\7~\2\2\u020e\u009a\3\2\2\2\u020f\u0210\7-\2"+
		"\2\u0210\u0211\7-\2\2\u0211\u009c\3\2\2\2\u0212\u0213\7/\2\2\u0213\u0214"+
		"\7/\2\2\u0214\u009e\3\2\2\2\u0215\u0216\7-\2\2\u0216\u00a0\3\2\2\2\u0217"+
		"\u0218\7/\2\2\u0218\u00a2\3\2\2\2\u0219\u021a\7,\2\2\u021a\u00a4\3\2\2"+
		"\2\u021b\u021c\7\61\2\2\u021c\u00a6\3\2\2\2\u021d\u021e\7(\2\2\u021e\u00a8"+
		"\3\2\2\2\u021f\u0220\7~\2\2\u0220\u00aa\3\2\2\2\u0221\u0222\7`\2\2\u0222"+
		"\u00ac\3\2\2\2\u0223\u0224\7\'\2\2\u0224\u00ae\3\2\2\2\u0225\u0229\5\u00b1"+
		"Y\2\u0226\u0228\5\u00b3Z\2\u0227\u0226\3\2\2\2\u0228\u022b\3\2\2\2\u0229"+
		"\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u00b0\3\2\2\2\u022b\u0229\3\2"+
		"\2\2\u022c\u0233\t\21\2\2\u022d\u022e\n\22\2\2\u022e\u0233\6Y\2\2\u022f"+
		"\u0230\t\23\2\2\u0230\u0231\t\24\2\2\u0231\u0233\6Y\3\2\u0232\u022c\3"+
		"\2\2\2\u0232\u022d\3\2\2\2\u0232\u022f\3\2\2\2\u0233\u00b2\3\2\2\2\u0234"+
		"\u023b\t\25\2\2\u0235\u0236\n\22\2\2\u0236\u023b\6Z\4\2\u0237\u0238\t"+
		"\23\2\2\u0238\u0239\t\24\2\2\u0239\u023b\6Z\5\2\u023a\u0234\3\2\2\2\u023a"+
		"\u0235\3\2\2\2\u023a\u0237\3\2\2\2\u023b\u00b4\3\2\2\2\u023c\u023e\t\26"+
		"\2\2\u023d\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u023d\3\2\2\2\u023f"+
		"\u0240\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\b[\2\2\u0242\u00b6\3\2"+
		"\2\2\u0243\u0244\7\61\2\2\u0244\u0245\7,\2\2\u0245\u0249\3\2\2\2\u0246"+
		"\u0248\13\2\2\2\u0247\u0246\3\2\2\2\u0248\u024b\3\2\2\2\u0249\u024a\3"+
		"\2\2\2\u0249\u0247\3\2\2\2\u024a\u024c\3\2\2\2\u024b\u0249\3\2\2\2\u024c"+
		"\u024d\7,\2\2\u024d\u024e\7\61\2\2\u024e\u024f\3\2\2\2\u024f\u0250\b\\"+
		"\3\2\u0250\u00b8\3\2\2\2\u0251\u0252\7\61\2\2\u0252\u0253\7\61\2\2\u0253"+
		"\u0257\3\2\2\2\u0254\u0256\n\27\2\2\u0255\u0254\3\2\2\2\u0256\u0259\3"+
		"\2\2\2\u0257\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u025a\3\2\2\2\u0259"+
		"\u0257\3\2\2\2\u025a\u025b\b]\3\2\u025b\u00ba\3\2\2\29\2\u00ca\u00ce\u00d2"+
		"\u00d6\u00da\u00e1\u00e6\u00e8\u00ec\u00ef\u00f3\u00fa\u00fe\u0103\u010b"+
		"\u010e\u0115\u0119\u011d\u0123\u0126\u012d\u0131\u0139\u013c\u0143\u0147"+
		"\u014b\u0150\u0153\u0156\u015b\u015e\u0163\u0168\u0170\u017b\u017f\u0184"+
		"\u0188\u0198\u01a2\u01a8\u01af\u01b3\u01b9\u01c6\u01ce\u0229\u0232\u023a"+
		"\u023f\u0249\u0257\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}