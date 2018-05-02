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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		SubBase=10, Turnstile=11, EmptyContext=12, ForAll=13, Arrow=14, Lambda=15, 
		Identifier=16, IdentifierLetter=17, Digit=18, LineComment=19, WhiteSpace=20, 
		AnyCharacter=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"SubBase", "Turnstile", "EmptyContext", "ForAll", "Arrow", "Lambda", "Identifier", 
		"IdentifierLetter", "Digit", "LineComment", "WhiteSpace", "AnyCharacter"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "';'", "':'", "'['", "']'", "'[['", "']]'", 
		"'SubBase'", null, "'.'", "'\\forall'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "SubBase", 
		"Turnstile", "EmptyContext", "ForAll", "Arrow", "Lambda", "Identifier", 
		"IdentifierLetter", "Digit", "LineComment", "WhiteSpace", "AnyCharacter"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u009d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\fU\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5"+
		"\17q\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20|\n\20\3\21"+
		"\3\21\3\21\7\21\u0081\n\21\f\21\16\21\u0084\13\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\7\24\u008c\n\24\f\24\16\24\u008f\13\24\3\24\3\24\3\24\3\24"+
		"\3\25\6\25\u0096\n\25\r\25\16\25\u0097\3\25\3\25\3\26\3\26\3\u008d\2\27"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27\3\2\4\5\2C\\aac|\5\2\13\13\17\17\"\"\2"+
		"\u00a5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5"+
		"/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2\179\3\2"+
		"\2\2\21;\3\2\2\2\23>\3\2\2\2\25A\3\2\2\2\27T\3\2\2\2\31V\3\2\2\2\33X\3"+
		"\2\2\2\35p\3\2\2\2\37{\3\2\2\2!}\3\2\2\2#\u0085\3\2\2\2%\u0087\3\2\2\2"+
		"\'\u0089\3\2\2\2)\u0095\3\2\2\2+\u009b\3\2\2\2-.\7*\2\2.\4\3\2\2\2/\60"+
		"\7.\2\2\60\6\3\2\2\2\61\62\7+\2\2\62\b\3\2\2\2\63\64\7=\2\2\64\n\3\2\2"+
		"\2\65\66\7<\2\2\66\f\3\2\2\2\678\7]\2\28\16\3\2\2\29:\7_\2\2:\20\3\2\2"+
		"\2;<\7]\2\2<=\7]\2\2=\22\3\2\2\2>?\7_\2\2?@\7_\2\2@\24\3\2\2\2AB\7U\2"+
		"\2BC\7w\2\2CD\7d\2\2DE\7D\2\2EF\7c\2\2FG\7u\2\2GH\7g\2\2H\26\3\2\2\2I"+
		"J\7\u00e4\2\2JK\7\u0162\2\2KU\7\u00a4\2\2LM\7~\2\2MU\7/\2\2NO\7^\2\2O"+
		"P\7x\2\2PQ\7f\2\2QR\7c\2\2RS\7u\2\2SU\7j\2\2TI\3\2\2\2TL\3\2\2\2TN\3\2"+
		"\2\2U\30\3\2\2\2VW\7\60\2\2W\32\3\2\2\2XY\7^\2\2YZ\7h\2\2Z[\7q\2\2[\\"+
		"\7t\2\2\\]\7c\2\2]^\7n\2\2^_\7n\2\2_\34\3\2\2\2`a\7\u00e4\2\2ab\7\u2022"+
		"\2\2bq\7\u201b\2\2cd\7/\2\2dq\7@\2\2ef\7^\2\2fg\7t\2\2gh\7k\2\2hi\7i\2"+
		"\2ij\7j\2\2jk\7v\2\2kl\7c\2\2lm\7t\2\2mn\7t\2\2no\7q\2\2oq\7y\2\2p`\3"+
		"\2\2\2pc\3\2\2\2pe\3\2\2\2q\36\3\2\2\2rs\7\u00d0\2\2s|\7\u00bd\2\2tu\7"+
		"^\2\2uv\7n\2\2vw\7c\2\2wx\7o\2\2xy\7d\2\2yz\7f\2\2z|\7c\2\2{r\3\2\2\2"+
		"{t\3\2\2\2| \3\2\2\2}\u0082\5#\22\2~\u0081\5#\22\2\177\u0081\5%\23\2\u0080"+
		"~\3\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\t\2\2\2"+
		"\u0086$\3\2\2\2\u0087\u0088\4\62;\2\u0088&\3\2\2\2\u0089\u008d\7\'\2\2"+
		"\u008a\u008c\13\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0091\7\f\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\24\2\2\u0093(\3\2\2\2"+
		"\u0094\u0096\t\3\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\b\25\2\2"+
		"\u009a*\3\2\2\2\u009b\u009c\13\2\2\2\u009c,\3\2\2\2\n\2Tp{\u0080\u0082"+
		"\u008d\u0097\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}