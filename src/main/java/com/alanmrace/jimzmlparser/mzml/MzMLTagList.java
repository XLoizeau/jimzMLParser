package com.alanmrace.jimzmlparser.mzml;

/**
 * Interface for all mzML tags which are lists, providing an API for adding, 
 * removing and retrieving members of the list.
 * 
 * @author Alan Race
 * @param <T> List element MzML tag 
 */
public interface MzMLTagList<T extends MzMLTag> extends Iterable<T> {
    
    /**
     * Add an item to the list. If an item is added which could be used as a reference
     * (i.e. something which extends MzMLIDContent) then the relevant 
     * 
     * @param item Item to add to the list
     */
    void add(T item);
    
    /**
     * Returns the item in the list at the specified index, or null if no such 
     * index exists.
     * 
     * @param index Index in the list
     * @return Item in the list at specified index, or null if none exists
     */
    T get(int index);
    
    /**
     * Remove an item in the list at the specified index.
     *  
     * @param index Index of the item to remove
     * @return Item removed from list, or null if nothing removed
     */
    T remove(int index);
    
    /**
     * Remove the specified item from the list.
     * 
     * @param item Item to remove
     * @return true if an item was removed from the list, false otherwise
     */
    boolean remove(T item);
    
    /**
     * Remove all entries from the list.
     */
    void clear();
    
    /**
     * Returns the index of the specified item in the list.
     * 
     * @param item Item to find index of
     * @return Index of specified item
     */
    int indexOf(T item);
    
    /**
     * Checks whether the list contains the specified item in the list.
     * 
     * @param item Item to check
     * @return true if item found in list, false otherwise
     */
    boolean contains(T item);
    
    /**
     * Returns the number of items in the list.
     * 
     * @return Number of items in the list
     */
    int size();
}
