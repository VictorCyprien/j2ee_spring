package fr.limayrac.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.definition.FlowDefinition;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.definition.TransitionDefinition;
import org.springframework.webflow.execution.*;

public class Fel implements FlowExecutionListener{
	static Logger logger = LoggerFactory.getLogger(Fel.class);
	
	@Override
	public void requestSubmitted(RequestContext context) {
		FlowExecutionListener.super.requestSubmitted(context);
		logger.debug("requestSubmitted");
	}

	@Override
	public void requestProcessed(RequestContext context) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.requestProcessed(context);
	}

	@Override
	public void sessionCreating(RequestContext context, FlowDefinition definition) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.sessionCreating(context, definition);
	}

	@Override
	public void sessionStarting(RequestContext context, FlowSession session, MutableAttributeMap<?> input) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.sessionStarting(context, session, input);
	}

	@Override
	public void sessionStarted(RequestContext context, FlowSession session) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.sessionStarted(context, session);
	}

	@Override
	public void eventSignaled(RequestContext context, Event event) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.eventSignaled(context, event);
	}

	@Override
	public void transitionExecuting(RequestContext context, TransitionDefinition transition) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.transitionExecuting(context, transition);
	}

	@Override
	public void stateEntering(RequestContext context, StateDefinition state) throws EnterStateVetoException {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.stateEntering(context, state);
	}

	@Override
	public void stateEntered(RequestContext context, StateDefinition previousState, StateDefinition state) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.stateEntered(context, previousState, state);
	}

	@Override
	public void viewRendering(RequestContext context, View view, StateDefinition viewState) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.viewRendering(context, view, viewState);
	}

	@Override
	public void viewRendered(RequestContext context, View view, StateDefinition viewState) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.viewRendered(context, view, viewState);
	}

	@Override
	public void paused(RequestContext context) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.paused(context);
	}

	@Override
	public void resuming(RequestContext context) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.resuming(context);
	}

	@Override
	public void sessionEnding(RequestContext context, FlowSession session, String outcome,
			MutableAttributeMap<?> output) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.sessionEnding(context, session, outcome, output);
	}

	@Override
	public void sessionEnded(RequestContext context, FlowSession session, String outcome, AttributeMap<?> output) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.sessionEnded(context, session, outcome, output);
	}

	@Override
	public void exceptionThrown(RequestContext context, FlowExecutionException exception) {
		// TODO Auto-generated method stub
		FlowExecutionListener.super.exceptionThrown(context, exception);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}
