// Generated from SystemF.g4 by ANTLR 4.7.1
package parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SystemFParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, SubBase=8, Turnstile=9, 
		EmptyContext=10, ForAll=11, Arrow=12, Lambda=13, Identifier=14, IdentifierLetter=15, 
		Digit=16, LineComment=17, WhiteSpace=18, AnyCharacter=19;
	public static final int
		RULE_systemF = 0, RULE_subtype = 1, RULE_judgment = 2, RULE_typingContext = 3, 
		RULE_type = 4, RULE_term = 5, RULE_variable = 6, RULE_application = 7, 
		RULE_lambda = 8;
	public static final String[] ruleNames = {
		"systemF", "subtype", "judgment", "typingContext", "type", "term", "variable", 
		"application", "lambda"
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

	@Override
	public String getGrammarFileName() { return "SystemF.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SystemFParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SystemFContext extends ParserRuleContext {
		public JudgmentContext judgment() {
			return getRuleContext(JudgmentContext.class,0);
		}
		public List<SubtypeContext> subtype() {
			return getRuleContexts(SubtypeContext.class);
		}
		public SubtypeContext subtype(int i) {
			return getRuleContext(SubtypeContext.class,i);
		}
		public SystemFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterSystemF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitSystemF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitSystemF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemFContext systemF() throws RecognitionException {
		SystemFContext _localctx = new SystemFContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_systemF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SubBase) {
				{
				{
				setState(18);
				subtype();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			judgment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubtypeContext extends ParserRuleContext {
		public TerminalNode SubBase() { return getToken(SystemFParser.SubBase, 0); }
		public List<TerminalNode> Identifier() { return getTokens(SystemFParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SystemFParser.Identifier, i);
		}
		public SubtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterSubtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitSubtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitSubtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtypeContext subtype() throws RecognitionException {
		SubtypeContext _localctx = new SubtypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_subtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(SubBase);
			setState(27);
			match(T__0);
			setState(28);
			match(Identifier);
			setState(29);
			match(T__1);
			setState(30);
			match(Identifier);
			setState(31);
			match(T__2);
			setState(32);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JudgmentContext extends ParserRuleContext {
		public TypingContextContext typingContext() {
			return getRuleContext(TypingContextContext.class,0);
		}
		public TerminalNode Turnstile() { return getToken(SystemFParser.Turnstile, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public JudgmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_judgment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterJudgment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitJudgment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitJudgment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JudgmentContext judgment() throws RecognitionException {
		JudgmentContext _localctx = new JudgmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_judgment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			typingContext();
			setState(35);
			match(Turnstile);
			setState(36);
			term();
			setState(37);
			match(T__4);
			setState(38);
			type(0);
			setState(39);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypingContextContext extends ParserRuleContext {
		public TerminalNode EmptyContext() { return getToken(SystemFParser.EmptyContext, 0); }
		public List<TerminalNode> Identifier() { return getTokens(SystemFParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SystemFParser.Identifier, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypingContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typingContext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterTypingContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitTypingContext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitTypingContext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypingContextContext typingContext() throws RecognitionException {
		TypingContextContext _localctx = new TypingContextContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typingContext);
		int _la;
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EmptyContext:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(EmptyContext);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(42);
				match(Identifier);
				setState(43);
				match(T__4);
				setState(44);
				type(0);
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(46);
					match(T__1);
					setState(47);
					match(Identifier);
					setState(48);
					match(T__4);
					setState(49);
					type(0);
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SystemFParser.Identifier, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode ForAll() { return getToken(SystemFParser.ForAll, 0); }
		public TerminalNode Arrow() { return getToken(SystemFParser.Arrow, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(58);
				match(Identifier);
				}
				break;
			case T__0:
				{
				setState(59);
				match(T__0);
				setState(60);
				type(0);
				setState(61);
				match(T__2);
				}
				break;
			case ForAll:
				{
				setState(63);
				match(ForAll);
				setState(64);
				match(Identifier);
				setState(65);
				match(EmptyContext);
				setState(66);
				type(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(69);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(70);
					match(Arrow);
					setState(71);
					type(4);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_term);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				variable();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				application();
				}
				break;
			case Lambda:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				lambda();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SystemFParser.Identifier, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ApplicationContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_application; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitApplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationContext application() throws RecognitionException {
		ApplicationContext _localctx = new ApplicationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_application);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__0);
			setState(85);
			term();
			setState(86);
			term();
			setState(87);
			match(T__2);
			setState(88);
			match(T__5);
			setState(89);
			type(0);
			setState(90);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode Lambda() { return getToken(SystemFParser.Lambda, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitLambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(Lambda);
			setState(93);
			match(EmptyContext);
			setState(94);
			term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25c\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\65\n\5\f"+
		"\5\16\58\13\5\5\5:\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6F\n"+
		"\6\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\3\7\3\7\3\7\5\7S\n\7\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\2\3\n\13\2\4\6\b\n"+
		"\f\16\20\22\2\2\2a\2\27\3\2\2\2\4\34\3\2\2\2\6$\3\2\2\2\b9\3\2\2\2\nE"+
		"\3\2\2\2\fR\3\2\2\2\16T\3\2\2\2\20V\3\2\2\2\22^\3\2\2\2\24\26\5\4\3\2"+
		"\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2"+
		"\31\27\3\2\2\2\32\33\5\6\4\2\33\3\3\2\2\2\34\35\7\n\2\2\35\36\7\3\2\2"+
		"\36\37\7\20\2\2\37 \7\4\2\2 !\7\20\2\2!\"\7\5\2\2\"#\7\6\2\2#\5\3\2\2"+
		"\2$%\5\b\5\2%&\7\13\2\2&\'\5\f\7\2\'(\7\7\2\2()\5\n\6\2)*\7\6\2\2*\7\3"+
		"\2\2\2+:\7\f\2\2,-\7\20\2\2-.\7\7\2\2./\5\n\6\2/\66\3\2\2\2\60\61\7\4"+
		"\2\2\61\62\7\20\2\2\62\63\7\7\2\2\63\65\5\n\6\2\64\60\3\2\2\2\658\3\2"+
		"\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67:\3\2\2\28\66\3\2\2\29+\3\2\2\29,\3"+
		"\2\2\2:\t\3\2\2\2;<\b\6\1\2<F\7\20\2\2=>\7\3\2\2>?\5\n\6\2?@\7\5\2\2@"+
		"F\3\2\2\2AB\7\r\2\2BC\7\20\2\2CD\7\f\2\2DF\5\n\6\3E;\3\2\2\2E=\3\2\2\2"+
		"EA\3\2\2\2FL\3\2\2\2GH\f\5\2\2HI\7\16\2\2IK\5\n\6\6JG\3\2\2\2KN\3\2\2"+
		"\2LJ\3\2\2\2LM\3\2\2\2M\13\3\2\2\2NL\3\2\2\2OS\5\16\b\2PS\5\20\t\2QS\5"+
		"\22\n\2RO\3\2\2\2RP\3\2\2\2RQ\3\2\2\2S\r\3\2\2\2TU\7\20\2\2U\17\3\2\2"+
		"\2VW\7\3\2\2WX\5\f\7\2XY\5\f\7\2YZ\7\5\2\2Z[\7\b\2\2[\\\5\n\6\2\\]\7\t"+
		"\2\2]\21\3\2\2\2^_\7\17\2\2_`\7\f\2\2`a\5\f\7\2a\23\3\2\2\2\b\27\669E"+
		"LR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}