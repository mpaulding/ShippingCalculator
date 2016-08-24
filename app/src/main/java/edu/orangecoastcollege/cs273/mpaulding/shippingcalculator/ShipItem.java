package edu.orangecoastcollege.cs273.mpaulding.shippingcalculator;

/**
 * Class represents an item to be shipped, represented with weight (in ounces),
 * base cost, added cost and total cost.
 * Created by mpaulding on 8/24/2016.
 */
public class ShipItem {

    private static final double BASE = 3.00;
    private static final double ADDED = 0.50;
    private static final double BASE_WEIGHT = 16.0;
    private static final double EXTRA_OUNCES = 4.0;

    private double mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCost;

    public ShipItem()
    {
        mWeight = 0.0;
        mBaseCost = BASE;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
    }

    public void setWeight(int weight)
    {
        mWeight = weight;
        computeCosts();
    }

    private void computeCosts()
    {
        mAddedCost = 0.0;
        mBaseCost = BASE;

        if (mWeight <= 0)
            mBaseCost = 0.0;
        else if (mWeight > BASE_WEIGHT)
            mAddedCost = Math.ceil((mWeight - BASE_WEIGHT) / EXTRA_OUNCES) * ADDED;

        mTotalCost = mBaseCost + mTotalCost;
    }

    public double getBaseCost()
    {
        return mBaseCost;
    }

    public double getAddedCost()
    {
        return mAddedCost;
    }

    public double getmTotalCost()
    {
        return mTotalCost;
    }

}
