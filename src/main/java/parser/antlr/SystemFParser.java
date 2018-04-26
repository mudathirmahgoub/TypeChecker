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
		RULE_type = 4, RULE_baseType = 5, RULE_forAllType = 6, RULE_arrowType = 7, 
		RULE_term = 8, RULE_variable = 9, RULE_application = 10, RULE_lambda = 11;
	public static final String[] ruleNames = {
		"systemF", "subtype", "judgment", "typingContext", "type", "baseType", 
		"forAllType", "arrowType", "term", "variable", "application", "lambda"
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
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SubBase) {
				{
				{
				setState(24);
				subtype();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
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
			setState(32);
			match(SubBase);
			setState(33);
			match(T__0);
			setState(34);
			match(Identifier);
			setState(35);
			match(T__1);
			setState(36);
			match(Identifier);
			setState(37);
			match(T__2);
			setState(38);
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
			setState(40);
			typingContext();
			setState(41);
			match(Turnstile);
			setState(42);
			term();
			setState(43);
			match(T__4);
			setState(44);
			type();
			setState(45);
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
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EmptyContext:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(EmptyContext);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(48);
				match(Identifier);
				setState(49);
				match(T__4);
				setState(50);
				type();
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(52);
					match(T__1);
					setState(53);
					match(Identifier);
					setState(54);
					match(T__4);
					setState(55);
					type();
					}
					}
					setState(60);
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
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public ArrowTypeContext arrowType() {
			return getRuleContext(ArrowTypeContext.class,0);
		}
		public ForAllTypeContext forAllType() {
			return getRuleContext(ForAllTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				baseType();
				setState(65);
				arrowType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				forAllType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				forAllType();
				setState(69);
				arrowType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				match(T__0);
				setState(72);
				type();
				setState(73);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				match(T__0);
				setState(76);
				type();
				setState(77);
				match(T__2);
				setState(78);
				arrowType();
				}
				break;
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

	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SystemFParser.Identifier, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_baseType);
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

	public static class ForAllTypeContext extends ParserRuleContext {
		public TerminalNode ForAll() { return getToken(SystemFParser.ForAll, 0); }
		public TerminalNode Identifier() { return getToken(SystemFParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ForAllTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forAllType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterForAllType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitForAllType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitForAllType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForAllTypeContext forAllType() throws RecognitionException {
		ForAllTypeContext _localctx = new ForAllTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forAllType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(ForAll);
			setState(85);
			match(Identifier);
			setState(86);
			match(EmptyContext);
			setState(87);
			type();
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

	public static class ArrowTypeContext extends ParserRuleContext {
		public TerminalNode Arrow() { return getToken(SystemFParser.Arrow, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrowTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).enterArrowType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemFListener ) ((SystemFListener)listener).exitArrowType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SystemFVisitor ) return ((SystemFVisitor<? extends T>)visitor).visitArrowType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrowTypeContext arrowType() throws RecognitionException {
		ArrowTypeContext _localctx = new ArrowTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arrowType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(Arrow);
			setState(90);
			type();
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
		enterRule(_localctx, 16, RULE_term);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				variable();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				application();
				}
				break;
			case Lambda:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
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
		enterRule(_localctx, 18, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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
		enterRule(_localctx, 20, RULE_application);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__0);
			setState(100);
			term();
			setState(101);
			term();
			setState(102);
			match(T__2);
			setState(103);
			match(T__5);
			setState(104);
			type();
			setState(105);
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
		enterRule(_localctx, 22, RULE_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(Lambda);
			setState(108);
			match(EmptyContext);
			setState(109);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25r\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\7\5;\n\5\f\5\16\5>\13\5\5\5@\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6S\n\6\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\5\nb\n\n\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\2\2\2o\2\35\3\2\2\2\4\"\3\2\2\2\6*\3\2\2\2\b?\3\2\2\2\nR\3\2\2\2\f"+
		"T\3\2\2\2\16V\3\2\2\2\20[\3\2\2\2\22a\3\2\2\2\24c\3\2\2\2\26e\3\2\2\2"+
		"\30m\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35"+
		"\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\5\6\4\2!\3\3\2\2\2\"#\7\n\2\2"+
		"#$\7\3\2\2$%\7\20\2\2%&\7\4\2\2&\'\7\20\2\2\'(\7\5\2\2()\7\6\2\2)\5\3"+
		"\2\2\2*+\5\b\5\2+,\7\13\2\2,-\5\22\n\2-.\7\7\2\2./\5\n\6\2/\60\7\6\2\2"+
		"\60\7\3\2\2\2\61@\7\f\2\2\62\63\7\20\2\2\63\64\7\7\2\2\64\65\5\n\6\2\65"+
		"<\3\2\2\2\66\67\7\4\2\2\678\7\20\2\289\7\7\2\29;\5\n\6\2:\66\3\2\2\2;"+
		">\3\2\2\2<:\3\2\2\2<=\3\2\2\2=@\3\2\2\2><\3\2\2\2?\61\3\2\2\2?\62\3\2"+
		"\2\2@\t\3\2\2\2AS\5\f\7\2BC\5\f\7\2CD\5\20\t\2DS\3\2\2\2ES\5\16\b\2FG"+
		"\5\16\b\2GH\5\20\t\2HS\3\2\2\2IJ\7\3\2\2JK\5\n\6\2KL\7\5\2\2LS\3\2\2\2"+
		"MN\7\3\2\2NO\5\n\6\2OP\7\5\2\2PQ\5\20\t\2QS\3\2\2\2RA\3\2\2\2RB\3\2\2"+
		"\2RE\3\2\2\2RF\3\2\2\2RI\3\2\2\2RM\3\2\2\2S\13\3\2\2\2TU\7\20\2\2U\r\3"+
		"\2\2\2VW\7\r\2\2WX\7\20\2\2XY\7\f\2\2YZ\5\n\6\2Z\17\3\2\2\2[\\\7\16\2"+
		"\2\\]\5\n\6\2]\21\3\2\2\2^b\5\24\13\2_b\5\26\f\2`b\5\30\r\2a^\3\2\2\2"+
		"a_\3\2\2\2a`\3\2\2\2b\23\3\2\2\2cd\7\20\2\2d\25\3\2\2\2ef\7\3\2\2fg\5"+
		"\22\n\2gh\5\22\n\2hi\7\5\2\2ij\7\b\2\2jk\5\n\6\2kl\7\t\2\2l\27\3\2\2\2"+
		"mn\7\17\2\2no\7\f\2\2op\5\22\n\2p\31\3\2\2\2\7\35<?Ra";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}