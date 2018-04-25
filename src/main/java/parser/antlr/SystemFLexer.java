// Generated from SystemF.g4 by ANTLR 4.7.1
package parser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SystemFLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, SubBase=8, Turnstile=9, 
		EmptyContext=10, ForAll=11, Arrow=12, Lambda=13, Identifier=14, IdentifierLetter=15, 
		Digit=16, LineComment=17, WhiteSpace=18, AnyCharacter=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "SubBase", "Turnstile", 
		"EmptyContext", "ForAll", "Arrow", "Lambda", "Identifier", "IdentifierLetter", 
		"Digit", "LineComment", "WhiteSpace", "AnyCharacter"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "';'", "':'", "'['", "']'", "'SubBase'", null, 
		"'.'", "'\\forall'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "SubBase", "Turnstile", 
		"EmptyContext", "ForAll", "Arrow", "Lambda", "Identifier", "IdentifierLetter", 
		"Digit", "LineComment", "WhiteSpace", "AnyCharacter"
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


	public SystemFLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SystemF.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\nK\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rg"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16r\n\16\3\17\3\17"+
		"\3\17\7\17w\n\17\f\17\16\17z\13\17\3\20\3\20\3\21\3\21\3\22\3\22\7\22"+
		"\u0082\n\22\f\22\16\22\u0085\13\22\3\22\3\22\3\22\3\22\3\23\6\23\u008c"+
		"\n\23\r\23\16\23\u008d\3\23\3\23\3\24\3\24\3\u0083\2\25\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25\3\2\4\5\2C\\aac|\5\2\13\13\17\17\"\"\2\u009b\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7-\3\2\2\2\t/\3\2\2\2\13\61\3\2\2\2\r"+
		"\63\3\2\2\2\17\65\3\2\2\2\21\67\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27N\3"+
		"\2\2\2\31f\3\2\2\2\33q\3\2\2\2\35s\3\2\2\2\37{\3\2\2\2!}\3\2\2\2#\177"+
		"\3\2\2\2%\u008b\3\2\2\2\'\u0091\3\2\2\2)*\7*\2\2*\4\3\2\2\2+,\7.\2\2,"+
		"\6\3\2\2\2-.\7+\2\2.\b\3\2\2\2/\60\7=\2\2\60\n\3\2\2\2\61\62\7<\2\2\62"+
		"\f\3\2\2\2\63\64\7]\2\2\64\16\3\2\2\2\65\66\7_\2\2\66\20\3\2\2\2\678\7"+
		"U\2\289\7w\2\29:\7d\2\2:;\7D\2\2;<\7c\2\2<=\7u\2\2=>\7g\2\2>\22\3\2\2"+
		"\2?@\7\u00e4\2\2@A\7\u0162\2\2AK\7\u00a4\2\2BC\7~\2\2CK\7/\2\2DE\7^\2"+
		"\2EF\7x\2\2FG\7f\2\2GH\7c\2\2HI\7u\2\2IK\7j\2\2J?\3\2\2\2JB\3\2\2\2JD"+
		"\3\2\2\2K\24\3\2\2\2LM\7\60\2\2M\26\3\2\2\2NO\7^\2\2OP\7h\2\2PQ\7q\2\2"+
		"QR\7t\2\2RS\7c\2\2ST\7n\2\2TU\7n\2\2U\30\3\2\2\2VW\7\u00e4\2\2WX\7\u2022"+
		"\2\2Xg\7\u201b\2\2YZ\7/\2\2Zg\7@\2\2[\\\7^\2\2\\]\7t\2\2]^\7k\2\2^_\7"+
		"i\2\2_`\7j\2\2`a\7v\2\2ab\7c\2\2bc\7t\2\2cd\7t\2\2de\7q\2\2eg\7y\2\2f"+
		"V\3\2\2\2fY\3\2\2\2f[\3\2\2\2g\32\3\2\2\2hi\7\u00d0\2\2ir\7\u00bd\2\2"+
		"jk\7^\2\2kl\7n\2\2lm\7c\2\2mn\7o\2\2no\7d\2\2op\7f\2\2pr\7c\2\2qh\3\2"+
		"\2\2qj\3\2\2\2r\34\3\2\2\2sx\5\37\20\2tw\5\37\20\2uw\5!\21\2vt\3\2\2\2"+
		"vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\36\3\2\2\2zx\3\2\2\2{|\t\2\2"+
		"\2| \3\2\2\2}~\4\62;\2~\"\3\2\2\2\177\u0083\7\'\2\2\u0080\u0082\13\2\2"+
		"\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0084\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7\f\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\b\22\2\2\u0089$\3\2\2\2\u008a\u008c\t\3\2\2"+
		"\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\b\23\2\2\u0090&\3\2\2\2\u0091"+
		"\u0092\13\2\2\2\u0092(\3\2\2\2\n\2Jfqvx\u0083\u008d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}