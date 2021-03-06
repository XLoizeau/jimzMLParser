/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanmrace.jimzmlparser.obo;

import com.alanmrace.jimzmlparser.mzml.BinaryDataArray;
import com.alanmrace.jimzmlparser.mzml.CVParam;
import com.alanmrace.jimzmlparser.mzml.EmptyCVParam;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Tests for the ontology class OBO.
 * 
 * @author Alan Race
 */
public class OBOTest {

    /**
     * Location of the MS imaging ontology as a resource.
     */
    public static final String IMAGING_MS_OBO = "/obo/imagingMS.obo"; 
            
    /**
     * OBO ontology to test.
     */
    protected OBO obo;
        
    /**
     * Test of getOBO method, of class OBO.
     */
    @Test
    public void testGetOBO() {
//        obo = new OBO(OBOTest.class.getResource(IMAGING_MS_OBO).getPath());        
        System.out.println("getOBO");
        
        OBO obo = OBO.getOBO();
        
        assertNotNull(obo);
    }

    /**
     * Test of getTerm method, of class OBO.
     */
    @Test
    @Ignore
    public void testGetTerm() {
        System.out.println("getTerm");
        String id = "";
        OBO instance = null;
        OBOTerm expResult = null;
        OBOTerm result = instance.getTerm(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class OBO.
     */
    @Test
    @Ignore
    public void testToString() {
        System.out.println("toString");
        OBO instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void hasParentTest() {
        OBO obo = OBO.getOBO();

        CVParam param = new EmptyCVParam(obo.getTerm(BinaryDataArray.EXTERNAL_DATA_ID));

        assert (!param.getTerm().hasParent(obo.getTerm(BinaryDataArray.EXTERNAL_DATA_ID)));
    }
}
