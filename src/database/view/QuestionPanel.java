package database.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import database.model.Answer;
import database.model.Question;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Xyrephon on 4/27/2017.
 */
public class QuestionPanel implements HasAnswers {
    private JTextArea answer;
    private JTextArea question;
    private JPanel main;
    private Question q;

    public void setQuestion(Question q) {
        this.q = q;
    }

    public JTextArea getTextAnswer() {
        return answer;
    }

    public JTextArea getQuestion() {
        return question;
    }

    public JPanel getMain() {
        return main;
    }

    public Answer getAnswer() {
        Answer res = new Answer();
        res.setQuestion(q);
        res.setResponse(answer.getText());

        return res;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        main = new JPanel();
        main.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        answer = new JTextArea();
        answer.setWrapStyleWord(true);
        main.add(answer, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        question = new JTextArea();
        question.setEditable(false);
        question.setWrapStyleWord(true);
        main.add(question, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return main;
    }
}
