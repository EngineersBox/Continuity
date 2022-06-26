// Generated from ContinuityLexer.g4 by ANTLR 4.7.1

package com.engineersbox.continuity.lang.antlr;

import com.engineersbox.continuity.lang.lexer.LexerBase;

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
		IN_PARAM=1, IntegerLiteral=2, FloatingPointLiteral=3, BooleanLiteral=4, 
		CharacterLiteral=5, StringLiteral=6, NullLiteral=7, LPAREN=8, RPAREN=9, 
		LBRACE=10, RBRACE=11, LBRACK=12, RBRACK=13, SEMI=14, DOT=15, COMMA=16, 
		ASSIGN=17, GT=18, LT=19, BANG=20, TILDE=21, QUESTION=22, COLON=23, COLONCOLON=24, 
		EQUAL=25, LE=26, GE=27, NOTEQUAL=28, AND=29, OR=30, INC=31, DEC=32, ADD=33, 
		SUB=34, MUL=35, DIV=36, BITAND=37, BITOR=38, CARET=39, MOD=40, Identifier=41, 
		WS=42, COMMENT=43, LINE_COMMENT=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IN_PARAM", "IntegerLiteral", "DecimalIntegerLiteral", "HexIntegerLiteral", 
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
		null, "'in'", null, null, null, null, null, "'null'", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "';'", "'.'", "','", "'='", "'>'", "'<'", "'!'", 
		"'~'", "'?'", "':'", "'::'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", 
		"'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IN_PARAM", "IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", 
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
		case 85:
			return Letter_sempred((RuleContext)_localctx, predIndex);
		case 86:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0250\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\5\3\u00bf\n\3\3\4\3\4\5\4\u00c3\n\4\3\5\3\5\5\5\u00c7\n\5\3\6\3\6\5\6"+
		"\u00cb\n\6\3\7\3\7\5\7\u00cf\n\7\3\b\3\b\3\t\3\t\3\t\5\t\u00d6\n\t\3\t"+
		"\3\t\3\t\5\t\u00db\n\t\5\t\u00dd\n\t\3\n\3\n\5\n\u00e1\n\n\3\n\5\n\u00e4"+
		"\n\n\3\13\3\13\5\13\u00e8\n\13\3\f\3\f\3\r\6\r\u00ed\n\r\r\r\16\r\u00ee"+
		"\3\16\3\16\5\16\u00f3\n\16\3\17\6\17\u00f6\n\17\r\17\16\17\u00f7\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\5\21\u0100\n\21\3\21\5\21\u0103\n\21\3\22\3"+
		"\22\3\23\6\23\u0108\n\23\r\23\16\23\u0109\3\24\3\24\5\24\u010e\n\24\3"+
		"\25\3\25\5\25\u0112\n\25\3\25\3\25\3\26\3\26\5\26\u0118\n\26\3\26\5\26"+
		"\u011b\n\26\3\27\3\27\3\30\6\30\u0120\n\30\r\30\16\30\u0121\3\31\3\31"+
		"\5\31\u0126\n\31\3\32\3\32\3\32\3\32\3\33\3\33\5\33\u012e\n\33\3\33\5"+
		"\33\u0131\n\33\3\34\3\34\3\35\6\35\u0136\n\35\r\35\16\35\u0137\3\36\3"+
		"\36\5\36\u013c\n\36\3\37\3\37\5\37\u0140\n\37\3 \3 \3 \5 \u0145\n \3 "+
		"\5 \u0148\n \3 \5 \u014b\n \3 \3 \3 \5 \u0150\n \3 \5 \u0153\n \3 \3 "+
		"\3 \5 \u0158\n \3 \3 \3 \5 \u015d\n \3!\3!\3!\3\"\3\"\3#\5#\u0165\n#\3"+
		"#\3#\3$\3$\3%\3%\3&\3&\3&\5&\u0170\n&\3\'\3\'\5\'\u0174\n\'\3\'\3\'\3"+
		"\'\5\'\u0179\n\'\3\'\3\'\5\'\u017d\n\'\3(\3(\3(\3)\3)\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\5*\u018d\n*\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0197\n+\3,\3,\3-\3"+
		"-\5-\u019d\n-\3-\3-\3.\6.\u01a2\n.\r.\16.\u01a3\3/\3/\5/\u01a8\n/\3\60"+
		"\3\60\3\60\3\60\5\60\u01ae\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\5\61\u01bb\n\61\3\62\3\62\3\63\3\63\6\63\u01c1\n\63\r"+
		"\63\16\63\u01c2\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65"+
		"\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3"+
		"?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3"+
		"H\3I\3I\3I\3J\3J\3J\3K\3K\3K\3L\3L\3L\3M\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3"+
		"Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\7V\u021c\nV\fV\16V\u021f\13V\3W\3W\3W"+
		"\3W\3W\3W\5W\u0227\nW\3X\3X\3X\3X\3X\3X\5X\u022f\nX\3Y\6Y\u0232\nY\rY"+
		"\16Y\u0233\3Y\3Y\3Z\3Z\3Z\3Z\7Z\u023c\nZ\fZ\16Z\u023f\13Z\3Z\3Z\3Z\3Z"+
		"\3Z\3[\3[\3[\3[\7[\u024a\n[\f[\16[\u024d\13[\3[\3[\3\u023d\2\\\3\3\5\4"+
		"\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%"+
		"\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\5?\2A\2C\2E\2G\2I\2K\2M"+
		"\2O\2Q\2S\6U\7W\2Y\b[\2]\2_\2a\2c\2e\2g\ti\nk\13m\fo\rq\16s\17u\20w\21"+
		"y\22{\23}\24\177\25\u0081\26\u0083\27\u0085\30\u0087\31\u0089\32\u008b"+
		"\33\u008d\34\u008f\35\u0091\36\u0093\37\u0095 \u0097!\u0099\"\u009b#\u009d"+
		"$\u009f%\u00a1&\u00a3\'\u00a5(\u00a7)\u00a9*\u00ab+\u00ad\2\u00af\2\u00b1"+
		",\u00b3-\u00b5.\3\2\30\4\2NNnn\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2"+
		"DDdd\3\2\62\63\4\2GGgg\4\2--//\6\2FFHHffhh\4\2RRrr\6\2\f\f\17\17))^^\6"+
		"\2\f\f\17\17$$^^\n\2$$))^^ddhhppttvv\3\2\62\65\6\2&&C\\aac|\4\2\2\u0081"+
		"\ud802\udc01\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f"+
		"\16\17\"\"\4\2\f\f\17\17\2\u025f\2\3\3\2\2\2\2\5\3\2\2\2\2=\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\2Y\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3"+
		"\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2"+
		"\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2"+
		"\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d"+
		"\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2"+
		"\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f"+
		"\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2"+
		"\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5"+
		"\3\2\2\2\3\u00b7\3\2\2\2\5\u00be\3\2\2\2\7\u00c0\3\2\2\2\t\u00c4\3\2\2"+
		"\2\13\u00c8\3\2\2\2\r\u00cc\3\2\2\2\17\u00d0\3\2\2\2\21\u00dc\3\2\2\2"+
		"\23\u00de\3\2\2\2\25\u00e7\3\2\2\2\27\u00e9\3\2\2\2\31\u00ec\3\2\2\2\33"+
		"\u00f2\3\2\2\2\35\u00f5\3\2\2\2\37\u00f9\3\2\2\2!\u00fd\3\2\2\2#\u0104"+
		"\3\2\2\2%\u0107\3\2\2\2\'\u010d\3\2\2\2)\u010f\3\2\2\2+\u0115\3\2\2\2"+
		"-\u011c\3\2\2\2/\u011f\3\2\2\2\61\u0125\3\2\2\2\63\u0127\3\2\2\2\65\u012b"+
		"\3\2\2\2\67\u0132\3\2\2\29\u0135\3\2\2\2;\u013b\3\2\2\2=\u013f\3\2\2\2"+
		"?\u015c\3\2\2\2A\u015e\3\2\2\2C\u0161\3\2\2\2E\u0164\3\2\2\2G\u0168\3"+
		"\2\2\2I\u016a\3\2\2\2K\u016c\3\2\2\2M\u017c\3\2\2\2O\u017e\3\2\2\2Q\u0181"+
		"\3\2\2\2S\u018c\3\2\2\2U\u0196\3\2\2\2W\u0198\3\2\2\2Y\u019a\3\2\2\2["+
		"\u01a1\3\2\2\2]\u01a7\3\2\2\2_\u01ad\3\2\2\2a\u01ba\3\2\2\2c\u01bc\3\2"+
		"\2\2e\u01be\3\2\2\2g\u01c9\3\2\2\2i\u01ce\3\2\2\2k\u01d0\3\2\2\2m\u01d2"+
		"\3\2\2\2o\u01d4\3\2\2\2q\u01d6\3\2\2\2s\u01d8\3\2\2\2u\u01da\3\2\2\2w"+
		"\u01dc\3\2\2\2y\u01de\3\2\2\2{\u01e0\3\2\2\2}\u01e2\3\2\2\2\177\u01e4"+
		"\3\2\2\2\u0081\u01e6\3\2\2\2\u0083\u01e8\3\2\2\2\u0085\u01ea\3\2\2\2\u0087"+
		"\u01ec\3\2\2\2\u0089\u01ee\3\2\2\2\u008b\u01f1\3\2\2\2\u008d\u01f4\3\2"+
		"\2\2\u008f\u01f7\3\2\2\2\u0091\u01fa\3\2\2\2\u0093\u01fd\3\2\2\2\u0095"+
		"\u0200\3\2\2\2\u0097\u0203\3\2\2\2\u0099\u0206\3\2\2\2\u009b\u0209\3\2"+
		"\2\2\u009d\u020b\3\2\2\2\u009f\u020d\3\2\2\2\u00a1\u020f\3\2\2\2\u00a3"+
		"\u0211\3\2\2\2\u00a5\u0213\3\2\2\2\u00a7\u0215\3\2\2\2\u00a9\u0217\3\2"+
		"\2\2\u00ab\u0219\3\2\2\2\u00ad\u0226\3\2\2\2\u00af\u022e\3\2\2\2\u00b1"+
		"\u0231\3\2\2\2\u00b3\u0237\3\2\2\2\u00b5\u0245\3\2\2\2\u00b7\u00b8\7k"+
		"\2\2\u00b8\u00b9\7p\2\2\u00b9\4\3\2\2\2\u00ba\u00bf\5\7\4\2\u00bb\u00bf"+
		"\5\t\5\2\u00bc\u00bf\5\13\6\2\u00bd\u00bf\5\r\7\2\u00be\u00ba\3\2\2\2"+
		"\u00be\u00bb\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\6\3"+
		"\2\2\2\u00c0\u00c2\5\21\t\2\u00c1\u00c3\5\17\b\2\u00c2\u00c1\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\b\3\2\2\2\u00c4\u00c6\5\37\20\2\u00c5\u00c7\5\17"+
		"\b\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\n\3\2\2\2\u00c8\u00ca"+
		"\5)\25\2\u00c9\u00cb\5\17\b\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2"+
		"\u00cb\f\3\2\2\2\u00cc\u00ce\5\63\32\2\u00cd\u00cf\5\17\b\2\u00ce\u00cd"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\16\3\2\2\2\u00d0\u00d1\t\2\2\2\u00d1"+
		"\20\3\2\2\2\u00d2\u00dd\7\62\2\2\u00d3\u00da\5\27\f\2\u00d4\u00d6\5\23"+
		"\n\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00db\3\2\2\2\u00d7"+
		"\u00d8\5\35\17\2\u00d8\u00d9\5\23\n\2\u00d9\u00db\3\2\2\2\u00da\u00d5"+
		"\3\2\2\2\u00da\u00d7\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00d2\3\2\2\2\u00dc"+
		"\u00d3\3\2\2\2\u00dd\22\3\2\2\2\u00de\u00e3\5\25\13\2\u00df\u00e1\5\31"+
		"\r\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\5\25\13\2\u00e3\u00e0\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\24\3\2"+
		"\2\2\u00e5\u00e8\7\62\2\2\u00e6\u00e8\5\27\f\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e6\3\2\2\2\u00e8\26\3\2\2\2\u00e9\u00ea\t\3\2\2\u00ea\30\3\2\2\2\u00eb"+
		"\u00ed\5\33\16\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3"+
		"\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\32\3\2\2\2\u00f0\u00f3\5\25\13\2\u00f1"+
		"\u00f3\7a\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3\34\3\2\2\2"+
		"\u00f4\u00f6\7a\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5"+
		"\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\36\3\2\2\2\u00f9\u00fa\7\62\2\2\u00fa"+
		"\u00fb\t\4\2\2\u00fb\u00fc\5!\21\2\u00fc \3\2\2\2\u00fd\u0102\5#\22\2"+
		"\u00fe\u0100\5%\23\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0103\5#\22\2\u0102\u00ff\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\"\3\2\2\2\u0104\u0105\t\5\2\2\u0105$\3\2\2\2\u0106\u0108\5\'\24\2\u0107"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a&\3\2\2\2\u010b\u010e\5#\22\2\u010c\u010e\7a\2\2\u010d\u010b"+
		"\3\2\2\2\u010d\u010c\3\2\2\2\u010e(\3\2\2\2\u010f\u0111\7\62\2\2\u0110"+
		"\u0112\5\35\17\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3"+
		"\2\2\2\u0113\u0114\5+\26\2\u0114*\3\2\2\2\u0115\u011a\5-\27\2\u0116\u0118"+
		"\5/\30\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u011b\5-\27\2\u011a\u0117\3\2\2\2\u011a\u011b\3\2\2\2\u011b,\3\2\2\2"+
		"\u011c\u011d\t\6\2\2\u011d.\3\2\2\2\u011e\u0120\5\61\31\2\u011f\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\60\3\2\2\2\u0123\u0126\5-\27\2\u0124\u0126\7a\2\2\u0125\u0123\3\2\2\2"+
		"\u0125\u0124\3\2\2\2\u0126\62\3\2\2\2\u0127\u0128\7\62\2\2\u0128\u0129"+
		"\t\7\2\2\u0129\u012a\5\65\33\2\u012a\64\3\2\2\2\u012b\u0130\5\67\34\2"+
		"\u012c\u012e\59\35\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f"+
		"\3\2\2\2\u012f\u0131\5\67\34\2\u0130\u012d\3\2\2\2\u0130\u0131\3\2\2\2"+
		"\u0131\66\3\2\2\2\u0132\u0133\t\b\2\2\u01338\3\2\2\2\u0134\u0136\5;\36"+
		"\2\u0135\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138"+
		"\3\2\2\2\u0138:\3\2\2\2\u0139\u013c\5\67\34\2\u013a\u013c\7a\2\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013a\3\2\2\2\u013c<\3\2\2\2\u013d\u0140\5? \2\u013e"+
		"\u0140\5K&\2\u013f\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140>\3\2\2\2\u0141"+
		"\u0142\5\23\n\2\u0142\u0144\7\60\2\2\u0143\u0145\5\23\n\2\u0144\u0143"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2\2\2\u0146\u0148\5A!\2\u0147"+
		"\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u014b\5I"+
		"%\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u015d\3\2\2\2\u014c"+
		"\u014d\7\60\2\2\u014d\u014f\5\23\n\2\u014e\u0150\5A!\2\u014f\u014e\3\2"+
		"\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u0153\5I%\2\u0152\u0151"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u015d\3\2\2\2\u0154\u0155\5\23\n\2"+
		"\u0155\u0157\5A!\2\u0156\u0158\5I%\2\u0157\u0156\3\2\2\2\u0157\u0158\3"+
		"\2\2\2\u0158\u015d\3\2\2\2\u0159\u015a\5\23\n\2\u015a\u015b\5I%\2\u015b"+
		"\u015d\3\2\2\2\u015c\u0141\3\2\2\2\u015c\u014c\3\2\2\2\u015c\u0154\3\2"+
		"\2\2\u015c\u0159\3\2\2\2\u015d@\3\2\2\2\u015e\u015f\5C\"\2\u015f\u0160"+
		"\5E#\2\u0160B\3\2\2\2\u0161\u0162\t\t\2\2\u0162D\3\2\2\2\u0163\u0165\5"+
		"G$\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u0167\5\23\n\2\u0167F\3\2\2\2\u0168\u0169\t\n\2\2\u0169H\3\2\2\2\u016a"+
		"\u016b\t\13\2\2\u016bJ\3\2\2\2\u016c\u016d\5M\'\2\u016d\u016f\5O(\2\u016e"+
		"\u0170\5I%\2\u016f\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170L\3\2\2\2\u0171"+
		"\u0173\5\37\20\2\u0172\u0174\7\60\2\2\u0173\u0172\3\2\2\2\u0173\u0174"+
		"\3\2\2\2\u0174\u017d\3\2\2\2\u0175\u0176\7\62\2\2\u0176\u0178\t\4\2\2"+
		"\u0177\u0179\5!\21\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a"+
		"\3\2\2\2\u017a\u017b\7\60\2\2\u017b\u017d\5!\21\2\u017c\u0171\3\2\2\2"+
		"\u017c\u0175\3\2\2\2\u017dN\3\2\2\2\u017e\u017f\5Q)\2\u017f\u0180\5E#"+
		"\2\u0180P\3\2\2\2\u0181\u0182\t\f\2\2\u0182R\3\2\2\2\u0183\u0184\7v\2"+
		"\2\u0184\u0185\7t\2\2\u0185\u0186\7w\2\2\u0186\u018d\7g\2\2\u0187\u0188"+
		"\7h\2\2\u0188\u0189\7c\2\2\u0189\u018a\7n\2\2\u018a\u018b\7u\2\2\u018b"+
		"\u018d\7g\2\2\u018c\u0183\3\2\2\2\u018c\u0187\3\2\2\2\u018dT\3\2\2\2\u018e"+
		"\u018f\7)\2\2\u018f\u0190\5W,\2\u0190\u0191\7)\2\2\u0191\u0197\3\2\2\2"+
		"\u0192\u0193\7)\2\2\u0193\u0194\5_\60\2\u0194\u0195\7)\2\2\u0195\u0197"+
		"\3\2\2\2\u0196\u018e\3\2\2\2\u0196\u0192\3\2\2\2\u0197V\3\2\2\2\u0198"+
		"\u0199\n\r\2\2\u0199X\3\2\2\2\u019a\u019c\7$\2\2\u019b\u019d\5[.\2\u019c"+
		"\u019b\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\7$"+
		"\2\2\u019fZ\3\2\2\2\u01a0\u01a2\5]/\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3"+
		"\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\\\3\2\2\2\u01a5"+
		"\u01a8\n\16\2\2\u01a6\u01a8\5_\60\2\u01a7\u01a5\3\2\2\2\u01a7\u01a6\3"+
		"\2\2\2\u01a8^\3\2\2\2\u01a9\u01aa\7^\2\2\u01aa\u01ae\t\17\2\2\u01ab\u01ae"+
		"\5a\61\2\u01ac\u01ae\5e\63\2\u01ad\u01a9\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad"+
		"\u01ac\3\2\2\2\u01ae`\3\2\2\2\u01af\u01b0\7^\2\2\u01b0\u01bb\5-\27\2\u01b1"+
		"\u01b2\7^\2\2\u01b2\u01b3\5-\27\2\u01b3\u01b4\5-\27\2\u01b4\u01bb\3\2"+
		"\2\2\u01b5\u01b6\7^\2\2\u01b6\u01b7\5c\62\2\u01b7\u01b8\5-\27\2\u01b8"+
		"\u01b9\5-\27\2\u01b9\u01bb\3\2\2\2\u01ba\u01af\3\2\2\2\u01ba\u01b1\3\2"+
		"\2\2\u01ba\u01b5\3\2\2\2\u01bbb\3\2\2\2\u01bc\u01bd\t\20\2\2\u01bdd\3"+
		"\2\2\2\u01be\u01c0\7^\2\2\u01bf\u01c1\7w\2\2\u01c0\u01bf\3\2\2\2\u01c1"+
		"\u01c2\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\3\2"+
		"\2\2\u01c4\u01c5\5#\22\2\u01c5\u01c6\5#\22\2\u01c6\u01c7\5#\22\2\u01c7"+
		"\u01c8\5#\22\2\u01c8f\3\2\2\2\u01c9\u01ca\7p\2\2\u01ca\u01cb\7w\2\2\u01cb"+
		"\u01cc\7n\2\2\u01cc\u01cd\7n\2\2\u01cdh\3\2\2\2\u01ce\u01cf\7*\2\2\u01cf"+
		"j\3\2\2\2\u01d0\u01d1\7+\2\2\u01d1l\3\2\2\2\u01d2\u01d3\7}\2\2\u01d3n"+
		"\3\2\2\2\u01d4\u01d5\7\177\2\2\u01d5p\3\2\2\2\u01d6\u01d7\7]\2\2\u01d7"+
		"r\3\2\2\2\u01d8\u01d9\7_\2\2\u01d9t\3\2\2\2\u01da\u01db\7=\2\2\u01dbv"+
		"\3\2\2\2\u01dc\u01dd\7\60\2\2\u01ddx\3\2\2\2\u01de\u01df\7.\2\2\u01df"+
		"z\3\2\2\2\u01e0\u01e1\7?\2\2\u01e1|\3\2\2\2\u01e2\u01e3\7@\2\2\u01e3~"+
		"\3\2\2\2\u01e4\u01e5\7>\2\2\u01e5\u0080\3\2\2\2\u01e6\u01e7\7#\2\2\u01e7"+
		"\u0082\3\2\2\2\u01e8\u01e9\7\u0080\2\2\u01e9\u0084\3\2\2\2\u01ea\u01eb"+
		"\7A\2\2\u01eb\u0086\3\2\2\2\u01ec\u01ed\7<\2\2\u01ed\u0088\3\2\2\2\u01ee"+
		"\u01ef\7<\2\2\u01ef\u01f0\7<\2\2\u01f0\u008a\3\2\2\2\u01f1\u01f2\7?\2"+
		"\2\u01f2\u01f3\7?\2\2\u01f3\u008c\3\2\2\2\u01f4\u01f5\7>\2\2\u01f5\u01f6"+
		"\7?\2\2\u01f6\u008e\3\2\2\2\u01f7\u01f8\7@\2\2\u01f8\u01f9\7?\2\2\u01f9"+
		"\u0090\3\2\2\2\u01fa\u01fb\7#\2\2\u01fb\u01fc\7?\2\2\u01fc\u0092\3\2\2"+
		"\2\u01fd\u01fe\7(\2\2\u01fe\u01ff\7(\2\2\u01ff\u0094\3\2\2\2\u0200\u0201"+
		"\7~\2\2\u0201\u0202\7~\2\2\u0202\u0096\3\2\2\2\u0203\u0204\7-\2\2\u0204"+
		"\u0205\7-\2\2\u0205\u0098\3\2\2\2\u0206\u0207\7/\2\2\u0207\u0208\7/\2"+
		"\2\u0208\u009a\3\2\2\2\u0209\u020a\7-\2\2\u020a\u009c\3\2\2\2\u020b\u020c"+
		"\7/\2\2\u020c\u009e\3\2\2\2\u020d\u020e\7,\2\2\u020e\u00a0\3\2\2\2\u020f"+
		"\u0210\7\61\2\2\u0210\u00a2\3\2\2\2\u0211\u0212\7(\2\2\u0212\u00a4\3\2"+
		"\2\2\u0213\u0214\7~\2\2\u0214\u00a6\3\2\2\2\u0215\u0216\7`\2\2\u0216\u00a8"+
		"\3\2\2\2\u0217\u0218\7\'\2\2\u0218\u00aa\3\2\2\2\u0219\u021d\5\u00adW"+
		"\2\u021a\u021c\5\u00afX\2\u021b\u021a\3\2\2\2\u021c\u021f\3\2\2\2\u021d"+
		"\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u00ac\3\2\2\2\u021f\u021d\3\2"+
		"\2\2\u0220\u0227\t\21\2\2\u0221\u0222\n\22\2\2\u0222\u0227\6W\2\2\u0223"+
		"\u0224\t\23\2\2\u0224\u0225\t\24\2\2\u0225\u0227\6W\3\2\u0226\u0220\3"+
		"\2\2\2\u0226\u0221\3\2\2\2\u0226\u0223\3\2\2\2\u0227\u00ae\3\2\2\2\u0228"+
		"\u022f\t\25\2\2\u0229\u022a\n\22\2\2\u022a\u022f\6X\4\2\u022b\u022c\t"+
		"\23\2\2\u022c\u022d\t\24\2\2\u022d\u022f\6X\5\2\u022e\u0228\3\2\2\2\u022e"+
		"\u0229\3\2\2\2\u022e\u022b\3\2\2\2\u022f\u00b0\3\2\2\2\u0230\u0232\t\26"+
		"\2\2\u0231\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0231\3\2\2\2\u0233"+
		"\u0234\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\bY\2\2\u0236\u00b2\3\2"+
		"\2\2\u0237\u0238\7\61\2\2\u0238\u0239\7,\2\2\u0239\u023d\3\2\2\2\u023a"+
		"\u023c\13\2\2\2\u023b\u023a\3\2\2\2\u023c\u023f\3\2\2\2\u023d\u023e\3"+
		"\2\2\2\u023d\u023b\3\2\2\2\u023e\u0240\3\2\2\2\u023f\u023d\3\2\2\2\u0240"+
		"\u0241\7,\2\2\u0241\u0242\7\61\2\2\u0242\u0243\3\2\2\2\u0243\u0244\bZ"+
		"\3\2\u0244\u00b4\3\2\2\2\u0245\u0246\7\61\2\2\u0246\u0247\7\61\2\2\u0247"+
		"\u024b\3\2\2\2\u0248\u024a\n\27\2\2\u0249\u0248\3\2\2\2\u024a\u024d\3"+
		"\2\2\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024e\3\2\2\2\u024d"+
		"\u024b\3\2\2\2\u024e\u024f\b[\3\2\u024f\u00b6\3\2\2\29\2\u00be\u00c2\u00c6"+
		"\u00ca\u00ce\u00d5\u00da\u00dc\u00e0\u00e3\u00e7\u00ee\u00f2\u00f7\u00ff"+
		"\u0102\u0109\u010d\u0111\u0117\u011a\u0121\u0125\u012d\u0130\u0137\u013b"+
		"\u013f\u0144\u0147\u014a\u014f\u0152\u0157\u015c\u0164\u016f\u0173\u0178"+
		"\u017c\u018c\u0196\u019c\u01a3\u01a7\u01ad\u01ba\u01c2\u021d\u0226\u022e"+
		"\u0233\u023d\u024b\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}