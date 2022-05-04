package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

@BytecodeGenerator
public class SwitchTableBuilder implements BytecodeBuilder {

    private InsnList indexInsnList;
    private InsnList defaultInsnList;
    private int caseStartIndex;
    private InsnList[] cases;

    public SwitchTableBuilder() {}

    public SwitchTableBuilder index(final InsnList indexInsnList) {
        if (indexInsnList == null) {
            throw new IllegalArgumentException("InsnList to get index must not be null");
        }
        this.indexInsnList = indexInsnList;
        return this;
    }

    public SwitchTableBuilder defaultBranch(final InsnList defaultInsnList) {
        if (defaultInsnList == null) {
            throw new IllegalArgumentException("InsnList for default branch must not be null");
        }
        this.defaultInsnList = defaultInsnList;
        return this;
    }

    public SwitchTableBuilder caseStartIndex(final int caseStartIndex) {
        if (caseStartIndex < 0) {
            throw new IllegalArgumentException("Start index must be at least 0");
        }
        this.caseStartIndex = caseStartIndex;
        return this;
    }

    public SwitchTableBuilder cases(final InsnList ...cases) {
        if (cases == null || Arrays.stream(cases).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Cases must not be null");
        } else if (cases.length <= 0) {
            throw new IllegalArgumentException("At least one case must be supplied");
        }
        this.cases = cases;
        return this;
    }

    @Override
    public InsnList build() {
        final InsnList ret = new InsnList();
        final LabelNode defaultLabelNode = new LabelNode();
        final LabelNode[] caseLabelNodes = Stream.generate(LabelNode::new)
                .limit(this.cases.length)
                .toArray(LabelNode[]::new);
        ret.add(indexInsnList);
        ret.add(new TableSwitchInsnNode(
                this.caseStartIndex,
                this.caseStartIndex + this.cases.length - 1,
                defaultLabelNode,
                caseLabelNodes
        ));
        for (int i = 0; i < this.cases.length; i++) {
            final LabelNode caseLabelNode = caseLabelNodes[i];
            final InsnList caseInsnList = this.cases[i];
            if (caseInsnList != null) {
                ret.add(caseLabelNode);
                ret.add(caseInsnList);
            }
        }
        if (defaultInsnList != null) {
            ret.add(defaultLabelNode);
            ret.add(defaultInsnList);
        }
        return ret;
    }
}
