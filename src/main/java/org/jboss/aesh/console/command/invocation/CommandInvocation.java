/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.aesh.console.command.invocation;

import org.jboss.aesh.console.AeshContext;
import org.jboss.aesh.console.Prompt;
import org.jboss.aesh.console.command.CommandOperation;
import org.jboss.aesh.console.command.registry.CommandRegistry;
import org.jboss.aesh.console.operator.ControlOperator;
import org.jboss.aesh.terminal.Shell;

/**
 * A CommandInvocation is the value object passed to a Command when it is executed.
 * It contain references to the current ControlOperator, registry, shell, ++
 *
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public interface CommandInvocation {

    /**
     * @return the control operator connected with this invocation
     */
    ControlOperator getControlOperator();

     /**
     * @return the CommandRegistry
     */
    CommandRegistry getCommandRegistry();

    /**
     * @return the shell
     */
    Shell getShell();

    /**
     * Specify the prompt
     */
    void setPrompt(Prompt prompt);

    /**
     * @return Get the current Prompt
     */
    Prompt getPrompt();

    /**
     * @return a formatted usage/help info from the specified command
     */
    String getHelpInfo(String commandName);

    /**
     * Stop the console and end the session
     */
    void stop();

    /**
     * Get AeshContext
     */
    AeshContext getAeshContext();

    /**
     * A blocking call that will return user input from the terminal
     *
     * @return user input
     * @throws InterruptedException
     */
    CommandOperation getInput() throws InterruptedException;

    /**
     * The process id.
     *
     * @return pid
     */
    int getPid();

    /**
     * Put the current process in the background
     */
    void putProcessInBackground();

    /**
     * Put the current process in the foreground
     */
    void putProcessInForeground();

    /**
     * This will push the input to the input stream where aesh will
     * parse it and execute it as a normal "user input".
     * The input will not be visible for the user.
     * Note that if this command still has the foreground this input
     * will just be sitting on the queue.
     *
     * @param input command input
     */
    void executeCommand(String input);
}