package com.alanmrace.jimzmlparser.mzML;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

public class SoftwareRef implements Serializable, MzMLTag { //, MutableTreeNode {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Software ref;

    public SoftwareRef(Software ref) {
        this.ref = ref;
    }

    public Software getRef() {
        return ref;
    }

    public void outputXML(BufferedWriter output) throws IOException {
        output.write("<softwareRef");
        output.write(" ref=\"" + ref.getID() + "\"");
        output.write("/>\n");
    }

    @Override
    public String toString() {
        return "softwareRef: " + ref.getID();
    }

    @Override
    public String getTagName() {
        return "softwareRef";
    }

    @Override
    public void addChildrenToCollection(Collection<MzMLTag> children) {
        // No children to add
    }
}