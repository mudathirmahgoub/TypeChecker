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
		Identifier=16, IdentifierLetter=17, Digit=18, WhiteSpace=19, AnyCharacter=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"SubBase", "Turnstile", "EmptyContext", "ForAll", "Arrow", "Lambda", "Identifier", 
		"IdentifierLetter", "Digit", "WhiteSpace", "AnyCharacter"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "';'", "':'", "'['", "']'", "'[['", "']]'", 
		"'SubBase'", null, "'.'", "'\\forall'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "SubBase", 
		"Turnstile", "EmptyContext", "ForAll", "Arrow", "Lambda", "Identifier", 
		"IdentifierLetter", "Digit", "WhiteSpace", "AnyCharacter"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fS\n\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17u\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u0080\n\20\3\21\3\21\3\21\7\21\u0085\n\21\f\21\16\21\u0088\13\21"+
		"\3\22\3\22\3\23\3\23\3\24\6\24\u008f\n\24\r\24\16\24\u0090\3\24\3\24\3"+
		"\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\4\5\2C\\aac|\5\2\13\f\17"+
		"\17\"\"\2\u009e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2"+
		"\2\2\7/\3\2\2\2\t\61\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2"+
		"\219\3\2\2\2\23<\3\2\2\2\25?\3\2\2\2\27R\3\2\2\2\31T\3\2\2\2\33V\3\2\2"+
		"\2\35t\3\2\2\2\37\177\3\2\2\2!\u0081\3\2\2\2#\u0089\3\2\2\2%\u008b\3\2"+
		"\2\2\'\u008e\3\2\2\2)\u0094\3\2\2\2+,\7*\2\2,\4\3\2\2\2-.\7.\2\2.\6\3"+
		"\2\2\2/\60\7+\2\2\60\b\3\2\2\2\61\62\7=\2\2\62\n\3\2\2\2\63\64\7<\2\2"+
		"\64\f\3\2\2\2\65\66\7]\2\2\66\16\3\2\2\2\678\7_\2\28\20\3\2\2\29:\7]\2"+
		"\2:;\7]\2\2;\22\3\2\2\2<=\7_\2\2=>\7_\2\2>\24\3\2\2\2?@\7U\2\2@A\7w\2"+
		"\2AB\7d\2\2BC\7D\2\2CD\7c\2\2DE\7u\2\2EF\7g\2\2F\26\3\2\2\2GH\7\u00e4"+
		"\2\2HI\7\u0162\2\2IS\7\u00a4\2\2JK\7~\2\2KS\7/\2\2LM\7^\2\2MN\7x\2\2N"+
		"O\7f\2\2OP\7c\2\2PQ\7u\2\2QS\7j\2\2RG\3\2\2\2RJ\3\2\2\2RL\3\2\2\2S\30"+
		"\3\2\2\2TU\7\60\2\2U\32\3\2\2\2VW\7^\2\2WX\7h\2\2XY\7q\2\2YZ\7t\2\2Z["+
		"\7c\2\2[\\\7n\2\2\\]\7n\2\2]\34\3\2\2\2^_\7\u00e4\2\2_`\7\u2022\2\2`u"+
		"\7\u201b\2\2ab\7/\2\2bu\7@\2\2cd\7^\2\2de\7t\2\2ef\7k\2\2fg\7i\2\2gh\7"+
		"j\2\2hi\7v\2\2ij\7c\2\2jk\7t\2\2kl\7t\2\2lm\7q\2\2mu\7y\2\2no\7^\2\2o"+
		"p\7w\2\2pq\7\64\2\2qr\7\63\2\2rs\7;\2\2su\7\64\2\2t^\3\2\2\2ta\3\2\2\2"+
		"tc\3\2\2\2tn\3\2\2\2u\36\3\2\2\2vw\7\u00d0\2\2w\u0080\7\u00bd\2\2xy\7"+
		"^\2\2yz\7n\2\2z{\7c\2\2{|\7o\2\2|}\7d\2\2}~\7f\2\2~\u0080\7c\2\2\177v"+
		"\3\2\2\2\177x\3\2\2\2\u0080 \3\2\2\2\u0081\u0086\5#\22\2\u0082\u0085\5"+
		"#\22\2\u0083\u0085\5%\23\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\"\3\2\2\2"+
		"\u0088\u0086\3\2\2\2\u0089\u008a\t\2\2\2\u008a$\3\2\2\2\u008b\u008c\4"+
		"\62;\2\u008c&\3\2\2\2\u008d\u008f\t\3\2\2\u008e\u008d\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\b\24\2\2\u0093(\3\2\2\2\u0094\u0095\13\2\2\2\u0095*\3\2\2\2\t\2"+
		"Rt\177\u0084\u0086\u0090\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}