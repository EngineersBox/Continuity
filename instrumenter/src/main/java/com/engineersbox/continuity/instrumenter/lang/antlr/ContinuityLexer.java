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
		CTX=1, EXT=2, FN=3, STD=4, IntegerLiteral=5, FloatingPointLiteral=6, BooleanLiteral=7, 
		CharacterLiteral=8, StringLiteral=9, NullLiteral=10, LPAREN=11, RPAREN=12, 
		LBRACE=13, RBRACE=14, LBRACK=15, RBRACK=16, SEMI=17, DOT=18, DOLLAR=19, 
		COMMA=20, ARROW=21, ASSIGN=22, GT=23, LT=24, BANG=25, TILDE=26, QUESTION=27, 
		COLON=28, COLONCOLON=29, EQUAL=30, LE=31, GE=32, NOTEQUAL=33, AND=34, 
		OR=35, INC=36, DEC=37, ADD=38, SUB=39, MUL=40, DIV=41, BITAND=42, BITOR=43, 
		CARET=44, MOD=45, Identifier=46, WS=47, COMMENT=48, LINE_COMMENT=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CTX", "EXT", "FN", "STD", "IntegerLiteral", "DecimalIntegerLiteral", 
		"HexIntegerLiteral", "OctalIntegerLiteral", "BinaryIntegerLiteral", "IntegerTypeSuffix", 
		"DecimalNumeral", "Digits", "Digit", "NonZeroDigit", "DigitsAndUnderscores", 
		"DigitOrUnderscore", "Underscores", "HexNumeral", "HexDigits", "HexDigit", 
		"HexDigitsAndUnderscores", "HexDigitOrUnderscore", "OctalNumeral", "OctalDigits", 
		"OctalDigit", "OctalDigitsAndUnderscores", "OctalDigitOrUnderscore", "BinaryNumeral", 
		"BinaryDigits", "BinaryDigit", "BinaryDigitsAndUnderscores", "BinaryDigitOrUnderscore", 
		"FloatingPointLiteral", "DecimalFloatingPointLiteral", "ExponentPart", 
		"ExponentIndicator", "SignedInteger", "Sign", "FloatTypeSuffix", "HexadecimalFloatingPointLiteral", 
		"HexSignificand", "BinaryExponent", "BinaryExponentIndicator", "BooleanLiteral", 
		"CharacterLiteral", "SingleCharacter", "StringLiteral", "StringCharacters", 
		"StringCharacter", "EscapeSequence", "OctalEscape", "ZeroToThree", "UnicodeEscape", 
		"NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
		"SEMI", "DOT", "DOLLAR", "COMMA", "ARROW", "ASSIGN", "GT", "LT", "BANG", 
		"TILDE", "QUESTION", "COLON", "COLONCOLON", "EQUAL", "LE", "GE", "NOTEQUAL", 
		"AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", 
		"CARET", "MOD", "Identifier", "Letter", "LetterOrDigit", "WS", "COMMENT", 
		"LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'ctx'", "'ext'", "'fn'", "'std'", null, null, null, null, null, 
		"'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", "'$'", 
		"','", "'->'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'::'", 
		"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", 
		"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CTX", "EXT", "FN", "STD", "IntegerLiteral", "FloatingPointLiteral", 
		"BooleanLiteral", "CharacterLiteral", "StringLiteral", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "DOT", 
		"DOLLAR", "COMMA", "ARROW", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", 
		"COLON", "COLONCOLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
		"DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", 
		"Identifier", "WS", "COMMENT", "LINE_COMMENT"
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
		case 90:
			return Letter_sempred((RuleContext)_localctx, predIndex);
		case 91:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u026b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_"+
		"\4`\t`\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\5\6\u00d5\n\6\3\7\3\7\5\7\u00d9\n\7\3\b\3\b\5\b\u00dd\n\b"+
		"\3\t\3\t\5\t\u00e1\n\t\3\n\3\n\5\n\u00e5\n\n\3\13\3\13\3\f\3\f\3\f\5\f"+
		"\u00ec\n\f\3\f\3\f\3\f\5\f\u00f1\n\f\5\f\u00f3\n\f\3\r\3\r\5\r\u00f7\n"+
		"\r\3\r\5\r\u00fa\n\r\3\16\3\16\5\16\u00fe\n\16\3\17\3\17\3\20\6\20\u0103"+
		"\n\20\r\20\16\20\u0104\3\21\3\21\5\21\u0109\n\21\3\22\6\22\u010c\n\22"+
		"\r\22\16\22\u010d\3\23\3\23\3\23\3\23\3\24\3\24\5\24\u0116\n\24\3\24\5"+
		"\24\u0119\n\24\3\25\3\25\3\26\6\26\u011e\n\26\r\26\16\26\u011f\3\27\3"+
		"\27\5\27\u0124\n\27\3\30\3\30\5\30\u0128\n\30\3\30\3\30\3\31\3\31\5\31"+
		"\u012e\n\31\3\31\5\31\u0131\n\31\3\32\3\32\3\33\6\33\u0136\n\33\r\33\16"+
		"\33\u0137\3\34\3\34\5\34\u013c\n\34\3\35\3\35\3\35\3\35\3\36\3\36\5\36"+
		"\u0144\n\36\3\36\5\36\u0147\n\36\3\37\3\37\3 \6 \u014c\n \r \16 \u014d"+
		"\3!\3!\5!\u0152\n!\3\"\3\"\5\"\u0156\n\"\3#\3#\3#\5#\u015b\n#\3#\5#\u015e"+
		"\n#\3#\5#\u0161\n#\3#\3#\3#\5#\u0166\n#\3#\5#\u0169\n#\3#\3#\3#\5#\u016e"+
		"\n#\3#\3#\3#\5#\u0173\n#\3$\3$\3$\3%\3%\3&\5&\u017b\n&\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\3)\5)\u0186\n)\3*\3*\5*\u018a\n*\3*\3*\3*\5*\u018f\n*\3*\3"+
		"*\5*\u0193\n*\3+\3+\3+\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u01a3\n-\3"+
		".\3.\3.\3.\3.\3.\3.\3.\5.\u01ad\n.\3/\3/\3\60\3\60\5\60\u01b3\n\60\3\60"+
		"\3\60\3\61\6\61\u01b8\n\61\r\61\16\61\u01b9\3\62\3\62\5\62\u01be\n\62"+
		"\3\63\3\63\3\63\3\63\5\63\u01c4\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\5\64\u01d1\n\64\3\65\3\65\3\66\3\66\6\66\u01d7\n"+
		"\66\r\66\16\66\u01d8\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67"+
		"\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3B"+
		"\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3J\3K\3K\3K\3L\3L\3L"+
		"\3M\3M\3M\3N\3N\3N\3O\3O\3O\3P\3P\3P\3Q\3Q\3Q\3R\3R\3R\3S\3S\3T\3T\3U"+
		"\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\7[\u0237\n[\f[\16[\u023a\13[\3"+
		"\\\3\\\3\\\3\\\3\\\3\\\5\\\u0242\n\\\3]\3]\3]\3]\3]\3]\5]\u024a\n]\3^"+
		"\6^\u024d\n^\r^\16^\u024e\3^\3^\3_\3_\3_\3_\7_\u0257\n_\f_\16_\u025a\13"+
		"_\3_\3_\3_\3_\3_\3`\3`\3`\3`\7`\u0265\n`\f`\16`\u0268\13`\3`\3`\3\u0258"+
		"\2a\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37"+
		"\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\bE\2G"+
		"\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\t[\n]\2_\13a\2c\2e\2g\2i\2k\2m\fo\rq\16s\17"+
		"u\20w\21y\22{\23}\24\177\25\u0081\26\u0083\27\u0085\30\u0087\31\u0089"+
		"\32\u008b\33\u008d\34\u008f\35\u0091\36\u0093\37\u0095 \u0097!\u0099\""+
		"\u009b#\u009d$\u009f%\u00a1&\u00a3\'\u00a5(\u00a7)\u00a9*\u00ab+\u00ad"+
		",\u00af-\u00b1.\u00b3/\u00b5\60\u00b7\2\u00b9\2\u00bb\61\u00bd\62\u00bf"+
		"\63\3\2\30\4\2NNnn\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62"+
		"\63\4\2GGgg\4\2--//\6\2FFHHffhh\4\2RRrr\6\2\f\f\17\17))^^\6\2\f\f\17\17"+
		"$$^^\n\2$$))^^ddhhppttvv\3\2\62\65\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01"+
		"\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4"+
		"\2\f\f\17\17\2\u027a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2C\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2_\3\2\2\2\2m\3\2\2\2\2o"+
		"\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2"+
		"\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2"+
		"\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf"+
		"\3\2\2\2\3\u00c1\3\2\2\2\5\u00c5\3\2\2\2\7\u00c9\3\2\2\2\t\u00cc\3\2\2"+
		"\2\13\u00d4\3\2\2\2\r\u00d6\3\2\2\2\17\u00da\3\2\2\2\21\u00de\3\2\2\2"+
		"\23\u00e2\3\2\2\2\25\u00e6\3\2\2\2\27\u00f2\3\2\2\2\31\u00f4\3\2\2\2\33"+
		"\u00fd\3\2\2\2\35\u00ff\3\2\2\2\37\u0102\3\2\2\2!\u0108\3\2\2\2#\u010b"+
		"\3\2\2\2%\u010f\3\2\2\2\'\u0113\3\2\2\2)\u011a\3\2\2\2+\u011d\3\2\2\2"+
		"-\u0123\3\2\2\2/\u0125\3\2\2\2\61\u012b\3\2\2\2\63\u0132\3\2\2\2\65\u0135"+
		"\3\2\2\2\67\u013b\3\2\2\29\u013d\3\2\2\2;\u0141\3\2\2\2=\u0148\3\2\2\2"+
		"?\u014b\3\2\2\2A\u0151\3\2\2\2C\u0155\3\2\2\2E\u0172\3\2\2\2G\u0174\3"+
		"\2\2\2I\u0177\3\2\2\2K\u017a\3\2\2\2M\u017e\3\2\2\2O\u0180\3\2\2\2Q\u0182"+
		"\3\2\2\2S\u0192\3\2\2\2U\u0194\3\2\2\2W\u0197\3\2\2\2Y\u01a2\3\2\2\2["+
		"\u01ac\3\2\2\2]\u01ae\3\2\2\2_\u01b0\3\2\2\2a\u01b7\3\2\2\2c\u01bd\3\2"+
		"\2\2e\u01c3\3\2\2\2g\u01d0\3\2\2\2i\u01d2\3\2\2\2k\u01d4\3\2\2\2m\u01df"+
		"\3\2\2\2o\u01e4\3\2\2\2q\u01e6\3\2\2\2s\u01e8\3\2\2\2u\u01ea\3\2\2\2w"+
		"\u01ec\3\2\2\2y\u01ee\3\2\2\2{\u01f0\3\2\2\2}\u01f2\3\2\2\2\177\u01f4"+
		"\3\2\2\2\u0081\u01f6\3\2\2\2\u0083\u01f8\3\2\2\2\u0085\u01fb\3\2\2\2\u0087"+
		"\u01fd\3\2\2\2\u0089\u01ff\3\2\2\2\u008b\u0201\3\2\2\2\u008d\u0203\3\2"+
		"\2\2\u008f\u0205\3\2\2\2\u0091\u0207\3\2\2\2\u0093\u0209\3\2\2\2\u0095"+
		"\u020c\3\2\2\2\u0097\u020f\3\2\2\2\u0099\u0212\3\2\2\2\u009b\u0215\3\2"+
		"\2\2\u009d\u0218\3\2\2\2\u009f\u021b\3\2\2\2\u00a1\u021e\3\2\2\2\u00a3"+
		"\u0221\3\2\2\2\u00a5\u0224\3\2\2\2\u00a7\u0226\3\2\2\2\u00a9\u0228\3\2"+
		"\2\2\u00ab\u022a\3\2\2\2\u00ad\u022c\3\2\2\2\u00af\u022e\3\2\2\2\u00b1"+
		"\u0230\3\2\2\2\u00b3\u0232\3\2\2\2\u00b5\u0234\3\2\2\2\u00b7\u0241\3\2"+
		"\2\2\u00b9\u0249\3\2\2\2\u00bb\u024c\3\2\2\2\u00bd\u0252\3\2\2\2\u00bf"+
		"\u0260\3\2\2\2\u00c1\u00c2\7e\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7z\2"+
		"\2\u00c4\4\3\2\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7z\2\2\u00c7\u00c8\7"+
		"v\2\2\u00c8\6\3\2\2\2\u00c9\u00ca\7h\2\2\u00ca\u00cb\7p\2\2\u00cb\b\3"+
		"\2\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7f\2\2\u00cf"+
		"\n\3\2\2\2\u00d0\u00d5\5\r\7\2\u00d1\u00d5\5\17\b\2\u00d2\u00d5\5\21\t"+
		"\2\u00d3\u00d5\5\23\n\2\u00d4\u00d0\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\f\3\2\2\2\u00d6\u00d8\5\27\f"+
		"\2\u00d7\u00d9\5\25\13\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\16\3\2\2\2\u00da\u00dc\5%\23\2\u00db\u00dd\5\25\13\2\u00dc\u00db\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\20\3\2\2\2\u00de\u00e0\5/\30\2\u00df\u00e1"+
		"\5\25\13\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\22\3\2\2\2\u00e2"+
		"\u00e4\59\35\2\u00e3\u00e5\5\25\13\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3"+
		"\2\2\2\u00e5\24\3\2\2\2\u00e6\u00e7\t\2\2\2\u00e7\26\3\2\2\2\u00e8\u00f3"+
		"\7\62\2\2\u00e9\u00f0\5\35\17\2\u00ea\u00ec\5\31\r\2\u00eb\u00ea\3\2\2"+
		"\2\u00eb\u00ec\3\2\2\2\u00ec\u00f1\3\2\2\2\u00ed\u00ee\5#\22\2\u00ee\u00ef"+
		"\5\31\r\2\u00ef\u00f1\3\2\2\2\u00f0\u00eb\3\2\2\2\u00f0\u00ed\3\2\2\2"+
		"\u00f1\u00f3\3\2\2\2\u00f2\u00e8\3\2\2\2\u00f2\u00e9\3\2\2\2\u00f3\30"+
		"\3\2\2\2\u00f4\u00f9\5\33\16\2\u00f5\u00f7\5\37\20\2\u00f6\u00f5\3\2\2"+
		"\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\5\33\16\2\u00f9"+
		"\u00f6\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\32\3\2\2\2\u00fb\u00fe\7\62\2"+
		"\2\u00fc\u00fe\5\35\17\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"\34\3\2\2\2\u00ff\u0100\t\3\2\2\u0100\36\3\2\2\2\u0101\u0103\5!\21\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105 \3\2\2\2\u0106\u0109\5\33\16\2\u0107\u0109\7a\2\2\u0108\u0106"+
		"\3\2\2\2\u0108\u0107\3\2\2\2\u0109\"\3\2\2\2\u010a\u010c\7a\2\2\u010b"+
		"\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2"+
		"\2\2\u010e$\3\2\2\2\u010f\u0110\7\62\2\2\u0110\u0111\t\4\2\2\u0111\u0112"+
		"\5\'\24\2\u0112&\3\2\2\2\u0113\u0118\5)\25\2\u0114\u0116\5+\26\2\u0115"+
		"\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\5)"+
		"\25\2\u0118\u0115\3\2\2\2\u0118\u0119\3\2\2\2\u0119(\3\2\2\2\u011a\u011b"+
		"\t\5\2\2\u011b*\3\2\2\2\u011c\u011e\5-\27\2\u011d\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120,\3\2\2\2"+
		"\u0121\u0124\5)\25\2\u0122\u0124\7a\2\2\u0123\u0121\3\2\2\2\u0123\u0122"+
		"\3\2\2\2\u0124.\3\2\2\2\u0125\u0127\7\62\2\2\u0126\u0128\5#\22\2\u0127"+
		"\u0126\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\5\61"+
		"\31\2\u012a\60\3\2\2\2\u012b\u0130\5\63\32\2\u012c\u012e\5\65\33\2\u012d"+
		"\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\5\63"+
		"\32\2\u0130\u012d\3\2\2\2\u0130\u0131\3\2\2\2\u0131\62\3\2\2\2\u0132\u0133"+
		"\t\6\2\2\u0133\64\3\2\2\2\u0134\u0136\5\67\34\2\u0135\u0134\3\2\2\2\u0136"+
		"\u0137\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\66\3\2\2"+
		"\2\u0139\u013c\5\63\32\2\u013a\u013c\7a\2\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013a\3\2\2\2\u013c8\3\2\2\2\u013d\u013e\7\62\2\2\u013e\u013f\t\7\2\2"+
		"\u013f\u0140\5;\36\2\u0140:\3\2\2\2\u0141\u0146\5=\37\2\u0142\u0144\5"+
		"? \2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0147\5=\37\2\u0146\u0143\3\2\2\2\u0146\u0147\3\2\2\2\u0147<\3\2\2\2"+
		"\u0148\u0149\t\b\2\2\u0149>\3\2\2\2\u014a\u014c\5A!\2\u014b\u014a\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"@\3\2\2\2\u014f\u0152\5=\37\2\u0150\u0152\7a\2\2\u0151\u014f\3\2\2\2\u0151"+
		"\u0150\3\2\2\2\u0152B\3\2\2\2\u0153\u0156\5E#\2\u0154\u0156\5Q)\2\u0155"+
		"\u0153\3\2\2\2\u0155\u0154\3\2\2\2\u0156D\3\2\2\2\u0157\u0158\5\31\r\2"+
		"\u0158\u015a\7\60\2\2\u0159\u015b\5\31\r\2\u015a\u0159\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u015e\5G$\2\u015d\u015c\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u0161\5O(\2\u0160\u015f\3\2\2"+
		"\2\u0160\u0161\3\2\2\2\u0161\u0173\3\2\2\2\u0162\u0163\7\60\2\2\u0163"+
		"\u0165\5\31\r\2\u0164\u0166\5G$\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2"+
		"\2\2\u0166\u0168\3\2\2\2\u0167\u0169\5O(\2\u0168\u0167\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\u0173\3\2\2\2\u016a\u016b\5\31\r\2\u016b\u016d\5G$\2\u016c"+
		"\u016e\5O(\2\u016d\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0173\3\2\2"+
		"\2\u016f\u0170\5\31\r\2\u0170\u0171\5O(\2\u0171\u0173\3\2\2\2\u0172\u0157"+
		"\3\2\2\2\u0172\u0162\3\2\2\2\u0172\u016a\3\2\2\2\u0172\u016f\3\2\2\2\u0173"+
		"F\3\2\2\2\u0174\u0175\5I%\2\u0175\u0176\5K&\2\u0176H\3\2\2\2\u0177\u0178"+
		"\t\t\2\2\u0178J\3\2\2\2\u0179\u017b\5M\'\2\u017a\u0179\3\2\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\5\31\r\2\u017dL\3\2\2\2\u017e"+
		"\u017f\t\n\2\2\u017fN\3\2\2\2\u0180\u0181\t\13\2\2\u0181P\3\2\2\2\u0182"+
		"\u0183\5S*\2\u0183\u0185\5U+\2\u0184\u0186\5O(\2\u0185\u0184\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u0186R\3\2\2\2\u0187\u0189\5%\23\2\u0188\u018a\7\60\2\2"+
		"\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0193\3\2\2\2\u018b\u018c"+
		"\7\62\2\2\u018c\u018e\t\4\2\2\u018d\u018f\5\'\24\2\u018e\u018d\3\2\2\2"+
		"\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\7\60\2\2\u0191\u0193"+
		"\5\'\24\2\u0192\u0187\3\2\2\2\u0192\u018b\3\2\2\2\u0193T\3\2\2\2\u0194"+
		"\u0195\5W,\2\u0195\u0196\5K&\2\u0196V\3\2\2\2\u0197\u0198\t\f\2\2\u0198"+
		"X\3\2\2\2\u0199\u019a\7v\2\2\u019a\u019b\7t\2\2\u019b\u019c\7w\2\2\u019c"+
		"\u01a3\7g\2\2\u019d\u019e\7h\2\2\u019e\u019f\7c\2\2\u019f\u01a0\7n\2\2"+
		"\u01a0\u01a1\7u\2\2\u01a1\u01a3\7g\2\2\u01a2\u0199\3\2\2\2\u01a2\u019d"+
		"\3\2\2\2\u01a3Z\3\2\2\2\u01a4\u01a5\7)\2\2\u01a5\u01a6\5]/\2\u01a6\u01a7"+
		"\7)\2\2\u01a7\u01ad\3\2\2\2\u01a8\u01a9\7)\2\2\u01a9\u01aa\5e\63\2\u01aa"+
		"\u01ab\7)\2\2\u01ab\u01ad\3\2\2\2\u01ac\u01a4\3\2\2\2\u01ac\u01a8\3\2"+
		"\2\2\u01ad\\\3\2\2\2\u01ae\u01af\n\r\2\2\u01af^\3\2\2\2\u01b0\u01b2\7"+
		"$\2\2\u01b1\u01b3\5a\61\2\u01b2\u01b1\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"\u01b4\3\2\2\2\u01b4\u01b5\7$\2\2\u01b5`\3\2\2\2\u01b6\u01b8\5c\62\2\u01b7"+
		"\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2"+
		"\2\2\u01bab\3\2\2\2\u01bb\u01be\n\16\2\2\u01bc\u01be\5e\63\2\u01bd\u01bb"+
		"\3\2\2\2\u01bd\u01bc\3\2\2\2\u01bed\3\2\2\2\u01bf\u01c0\7^\2\2\u01c0\u01c4"+
		"\t\17\2\2\u01c1\u01c4\5g\64\2\u01c2\u01c4\5k\66\2\u01c3\u01bf\3\2\2\2"+
		"\u01c3\u01c1\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4f\3\2\2\2\u01c5\u01c6\7"+
		"^\2\2\u01c6\u01d1\5\63\32\2\u01c7\u01c8\7^\2\2\u01c8\u01c9\5\63\32\2\u01c9"+
		"\u01ca\5\63\32\2\u01ca\u01d1\3\2\2\2\u01cb\u01cc\7^\2\2\u01cc\u01cd\5"+
		"i\65\2\u01cd\u01ce\5\63\32\2\u01ce\u01cf\5\63\32\2\u01cf\u01d1\3\2\2\2"+
		"\u01d0\u01c5\3\2\2\2\u01d0\u01c7\3\2\2\2\u01d0\u01cb\3\2\2\2\u01d1h\3"+
		"\2\2\2\u01d2\u01d3\t\20\2\2\u01d3j\3\2\2\2\u01d4\u01d6\7^\2\2\u01d5\u01d7"+
		"\7w\2\2\u01d6\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\5)\25\2\u01db\u01dc\5)"+
		"\25\2\u01dc\u01dd\5)\25\2\u01dd\u01de\5)\25\2\u01del\3\2\2\2\u01df\u01e0"+
		"\7p\2\2\u01e0\u01e1\7w\2\2\u01e1\u01e2\7n\2\2\u01e2\u01e3\7n\2\2\u01e3"+
		"n\3\2\2\2\u01e4\u01e5\7*\2\2\u01e5p\3\2\2\2\u01e6\u01e7\7+\2\2\u01e7r"+
		"\3\2\2\2\u01e8\u01e9\7}\2\2\u01e9t\3\2\2\2\u01ea\u01eb\7\177\2\2\u01eb"+
		"v\3\2\2\2\u01ec\u01ed\7]\2\2\u01edx\3\2\2\2\u01ee\u01ef\7_\2\2\u01efz"+
		"\3\2\2\2\u01f0\u01f1\7=\2\2\u01f1|\3\2\2\2\u01f2\u01f3\7\60\2\2\u01f3"+
		"~\3\2\2\2\u01f4\u01f5\7&\2\2\u01f5\u0080\3\2\2\2\u01f6\u01f7\7.\2\2\u01f7"+
		"\u0082\3\2\2\2\u01f8\u01f9\7/\2\2\u01f9\u01fa\7@\2\2\u01fa\u0084\3\2\2"+
		"\2\u01fb\u01fc\7?\2\2\u01fc\u0086\3\2\2\2\u01fd\u01fe\7@\2\2\u01fe\u0088"+
		"\3\2\2\2\u01ff\u0200\7>\2\2\u0200\u008a\3\2\2\2\u0201\u0202\7#\2\2\u0202"+
		"\u008c\3\2\2\2\u0203\u0204\7\u0080\2\2\u0204\u008e\3\2\2\2\u0205\u0206"+
		"\7A\2\2\u0206\u0090\3\2\2\2\u0207\u0208\7<\2\2\u0208\u0092\3\2\2\2\u0209"+
		"\u020a\7<\2\2\u020a\u020b\7<\2\2\u020b\u0094\3\2\2\2\u020c\u020d\7?\2"+
		"\2\u020d\u020e\7?\2\2\u020e\u0096\3\2\2\2\u020f\u0210\7>\2\2\u0210\u0211"+
		"\7?\2\2\u0211\u0098\3\2\2\2\u0212\u0213\7@\2\2\u0213\u0214\7?\2\2\u0214"+
		"\u009a\3\2\2\2\u0215\u0216\7#\2\2\u0216\u0217\7?\2\2\u0217\u009c\3\2\2"+
		"\2\u0218\u0219\7(\2\2\u0219\u021a\7(\2\2\u021a\u009e\3\2\2\2\u021b\u021c"+
		"\7~\2\2\u021c\u021d\7~\2\2\u021d\u00a0\3\2\2\2\u021e\u021f\7-\2\2\u021f"+
		"\u0220\7-\2\2\u0220\u00a2\3\2\2\2\u0221\u0222\7/\2\2\u0222\u0223\7/\2"+
		"\2\u0223\u00a4\3\2\2\2\u0224\u0225\7-\2\2\u0225\u00a6\3\2\2\2\u0226\u0227"+
		"\7/\2\2\u0227\u00a8\3\2\2\2\u0228\u0229\7,\2\2\u0229\u00aa\3\2\2\2\u022a"+
		"\u022b\7\61\2\2\u022b\u00ac\3\2\2\2\u022c\u022d\7(\2\2\u022d\u00ae\3\2"+
		"\2\2\u022e\u022f\7~\2\2\u022f\u00b0\3\2\2\2\u0230\u0231\7`\2\2\u0231\u00b2"+
		"\3\2\2\2\u0232\u0233\7\'\2\2\u0233\u00b4\3\2\2\2\u0234\u0238\5\u00b7\\"+
		"\2\u0235\u0237\5\u00b9]\2\u0236\u0235\3\2\2\2\u0237\u023a\3\2\2\2\u0238"+
		"\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u00b6\3\2\2\2\u023a\u0238\3\2"+
		"\2\2\u023b\u0242\t\21\2\2\u023c\u023d\n\22\2\2\u023d\u0242\6\\\2\2\u023e"+
		"\u023f\t\23\2\2\u023f\u0240\t\24\2\2\u0240\u0242\6\\\3\2\u0241\u023b\3"+
		"\2\2\2\u0241\u023c\3\2\2\2\u0241\u023e\3\2\2\2\u0242\u00b8\3\2\2\2\u0243"+
		"\u024a\t\25\2\2\u0244\u0245\n\22\2\2\u0245\u024a\6]\4\2\u0246\u0247\t"+
		"\23\2\2\u0247\u0248\t\24\2\2\u0248\u024a\6]\5\2\u0249\u0243\3\2\2\2\u0249"+
		"\u0244\3\2\2\2\u0249\u0246\3\2\2\2\u024a\u00ba\3\2\2\2\u024b\u024d\t\26"+
		"\2\2\u024c\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024c\3\2\2\2\u024e"+
		"\u024f\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0251\b^\2\2\u0251\u00bc\3\2"+
		"\2\2\u0252\u0253\7\61\2\2\u0253\u0254\7,\2\2\u0254\u0258\3\2\2\2\u0255"+
		"\u0257\13\2\2\2\u0256\u0255\3\2\2\2\u0257\u025a\3\2\2\2\u0258\u0259\3"+
		"\2\2\2\u0258\u0256\3\2\2\2\u0259\u025b\3\2\2\2\u025a\u0258\3\2\2\2\u025b"+
		"\u025c\7,\2\2\u025c\u025d\7\61\2\2\u025d\u025e\3\2\2\2\u025e\u025f\b_"+
		"\3\2\u025f\u00be\3\2\2\2\u0260\u0261\7\61\2\2\u0261\u0262\7\61\2\2\u0262"+
		"\u0266\3\2\2\2\u0263\u0265\n\27\2\2\u0264\u0263\3\2\2\2\u0265\u0268\3"+
		"\2\2\2\u0266\u0264\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2\2\2\u0268"+
		"\u0266\3\2\2\2\u0269\u026a\b`\3\2\u026a\u00c0\3\2\2\29\2\u00d4\u00d8\u00dc"+
		"\u00e0\u00e4\u00eb\u00f0\u00f2\u00f6\u00f9\u00fd\u0104\u0108\u010d\u0115"+
		"\u0118\u011f\u0123\u0127\u012d\u0130\u0137\u013b\u0143\u0146\u014d\u0151"+
		"\u0155\u015a\u015d\u0160\u0165\u0168\u016d\u0172\u017a\u0185\u0189\u018e"+
		"\u0192\u01a2\u01ac\u01b2\u01b9\u01bd\u01c3\u01d0\u01d8\u0238\u0241\u0249"+
		"\u024e\u0258\u0266\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}