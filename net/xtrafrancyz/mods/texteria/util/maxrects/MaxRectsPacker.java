package net.xtrafrancyz.mods.texteria.util.maxrects;

public class MaxRectsPacker
{
    private int binWidth;
    private int binHeight;
    private final GdxArray<MaxRectsPacker.Rect> usedRectangles = new GdxArray();
    private final GdxArray<MaxRectsPacker.Rect> freeRectangles = new GdxArray();

    public void init(int width, int height)
    {
        this.binWidth = width;
        this.binHeight = height;
        this.usedRectangles.clear();
        this.freeRectangles.clear();
        MaxRectsPacker.Rect maxrectspacker$rect = new MaxRectsPacker.Rect();
        maxrectspacker$rect.x = 0;
        maxrectspacker$rect.y = 0;
        maxrectspacker$rect.width = width;
        maxrectspacker$rect.height = height;
        this.freeRectangles.add(maxrectspacker$rect);
    }

    public MaxRectsPacker.Rect insert(MaxRectsPacker.Rect rect, MaxRectsPacker.FreeRectChoiceHeuristic method)
    {
        MaxRectsPacker.Rect maxrectspacker$rect = this.scoreRect(rect, method);

        if (maxrectspacker$rect.height == 0)
        {
            return null;
        }
        else
        {
            int i = this.freeRectangles.size;

            for (int j = 0; j < i; ++j)
            {
                if (this.splitFreeNode((MaxRectsPacker.Rect)this.freeRectangles.get(j), maxrectspacker$rect))
                {
                    this.freeRectangles.removeIndex(j);
                    --j;
                    --i;
                }
            }

            this.pruneFreeList();
            MaxRectsPacker.Rect maxrectspacker$rect1 = new MaxRectsPacker.Rect();
            maxrectspacker$rect1.set(rect);
            maxrectspacker$rect1.score1 = maxrectspacker$rect.score1;
            maxrectspacker$rect1.score2 = maxrectspacker$rect.score2;
            maxrectspacker$rect1.x = maxrectspacker$rect.x;
            maxrectspacker$rect1.y = maxrectspacker$rect.y;
            maxrectspacker$rect1.width = maxrectspacker$rect.width;
            maxrectspacker$rect1.height = maxrectspacker$rect.height;
            maxrectspacker$rect1.rotated = maxrectspacker$rect.rotated;
            this.usedRectangles.add(maxrectspacker$rect1);
            return maxrectspacker$rect1;
        }
    }

    public MaxRectsPacker.Page pack(GdxArray<MaxRectsPacker.Rect> rects, MaxRectsPacker.FreeRectChoiceHeuristic method)
    {
        rects = new GdxArray(rects);

        while (rects.size > 0)
        {
            int i = -1;
            MaxRectsPacker.Rect maxrectspacker$rect = new MaxRectsPacker.Rect();
            maxrectspacker$rect.score1 = Integer.MAX_VALUE;
            maxrectspacker$rect.score2 = Integer.MAX_VALUE;

            for (int j = 0; j < rects.size; ++j)
            {
                MaxRectsPacker.Rect maxrectspacker$rect1 = this.scoreRect((MaxRectsPacker.Rect)rects.get(j), method);

                if (maxrectspacker$rect1.score1 < maxrectspacker$rect.score1 || maxrectspacker$rect1.score1 == maxrectspacker$rect.score1 && maxrectspacker$rect1.score2 < maxrectspacker$rect.score2)
                {
                    maxrectspacker$rect.set((MaxRectsPacker.Rect)rects.get(j));
                    maxrectspacker$rect.score1 = maxrectspacker$rect1.score1;
                    maxrectspacker$rect.score2 = maxrectspacker$rect1.score2;
                    maxrectspacker$rect.x = maxrectspacker$rect1.x;
                    maxrectspacker$rect.y = maxrectspacker$rect1.y;
                    maxrectspacker$rect.width = maxrectspacker$rect1.width;
                    maxrectspacker$rect.height = maxrectspacker$rect1.height;
                    maxrectspacker$rect.rotated = maxrectspacker$rect1.rotated;
                    i = j;
                }
            }

            if (i == -1)
            {
                break;
            }

            this.placeRect(maxrectspacker$rect);
            rects.removeIndex(i);
        }

        MaxRectsPacker.Page maxrectspacker$page = this.getResult();
        maxrectspacker$page.remainingRects = rects;
        return maxrectspacker$page;
    }

    public MaxRectsPacker.Page getResult()
    {
        int i = 0;
        int j = 0;

        for (int k = 0; k < this.usedRectangles.size; ++k)
        {
            MaxRectsPacker.Rect maxrectspacker$rect = (MaxRectsPacker.Rect)this.usedRectangles.get(k);
            i = Math.max(i, maxrectspacker$rect.x + maxrectspacker$rect.width);
            j = Math.max(j, maxrectspacker$rect.y + maxrectspacker$rect.height);
        }

        MaxRectsPacker.Page maxrectspacker$page = new MaxRectsPacker.Page();
        maxrectspacker$page.outputRects = new GdxArray(this.usedRectangles);
        maxrectspacker$page.occupancy = this.getOccupancy();
        maxrectspacker$page.width = i;
        maxrectspacker$page.height = j;
        return maxrectspacker$page;
    }

    private void placeRect(MaxRectsPacker.Rect node)
    {
        int i = this.freeRectangles.size;

        for (int j = 0; j < i; ++j)
        {
            if (this.splitFreeNode((MaxRectsPacker.Rect)this.freeRectangles.get(j), node))
            {
                this.freeRectangles.removeIndex(j);
                --j;
                --i;
            }
        }

        this.pruneFreeList();
        this.usedRectangles.add(node);
    }

    private MaxRectsPacker.Rect scoreRect(MaxRectsPacker.Rect rect, MaxRectsPacker.FreeRectChoiceHeuristic method)
    {
        int i = rect.width;
        int j = rect.height;

        if (rect.canRotate)
        {
            ;
        }

        boolean flag = false;
        MaxRectsPacker.Rect maxrectspacker$rect = null;

        switch (method)
        {
            case BestShortSideFit:
                maxrectspacker$rect = this.findPositionForNewNodeBestShortSideFit(i, j, j, i, flag);
                break;

            case BottomLeftRule:
                maxrectspacker$rect = this.findPositionForNewNodeBottomLeft(i, j, j, i, flag);
                break;

            case ContactPointRule:
                maxrectspacker$rect = this.findPositionForNewNodeContactPoint(i, j, j, i, flag);
                maxrectspacker$rect.score1 = -maxrectspacker$rect.score1;
                break;

            case BestLongSideFit:
                maxrectspacker$rect = this.findPositionForNewNodeBestLongSideFit(i, j, j, i, flag);
                break;

            case BestAreaFit:
                maxrectspacker$rect = this.findPositionForNewNodeBestAreaFit(i, j, j, i, flag);
        }

        if (maxrectspacker$rect.height == 0)
        {
            maxrectspacker$rect.score1 = Integer.MAX_VALUE;
            maxrectspacker$rect.score2 = Integer.MAX_VALUE;
        }

        return maxrectspacker$rect;
    }

    private float getOccupancy()
    {
        int i = 0;

        for (int j = 0; j < this.usedRectangles.size; ++j)
        {
            i += ((MaxRectsPacker.Rect)this.usedRectangles.get(j)).width * ((MaxRectsPacker.Rect)this.usedRectangles.get(j)).height;
        }

        return (float)i / (float)(this.binWidth * this.binHeight);
    }

    private MaxRectsPacker.Rect findPositionForNewNodeBottomLeft(int width, int height, int rotatedWidth, int rotatedHeight, boolean rotate)
    {
        MaxRectsPacker.Rect maxrectspacker$rect = new MaxRectsPacker.Rect();
        maxrectspacker$rect.score1 = Integer.MAX_VALUE;

        for (int i = 0; i < this.freeRectangles.size; ++i)
        {
            if (((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width >= width && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height >= height)
            {
                int j = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y + height;

                if (j < maxrectspacker$rect.score1 || j == maxrectspacker$rect.score1 && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x < maxrectspacker$rect.score2)
                {
                    maxrectspacker$rect.x = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.y = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y;
                    maxrectspacker$rect.width = width;
                    maxrectspacker$rect.height = height;
                    maxrectspacker$rect.score1 = j;
                    maxrectspacker$rect.score2 = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.rotated = false;
                }
            }

            if (rotate && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width >= rotatedWidth && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height >= rotatedHeight)
            {
                int k = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y + rotatedHeight;

                if (k < maxrectspacker$rect.score1 || k == maxrectspacker$rect.score1 && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x < maxrectspacker$rect.score2)
                {
                    maxrectspacker$rect.x = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.y = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y;
                    maxrectspacker$rect.width = rotatedWidth;
                    maxrectspacker$rect.height = rotatedHeight;
                    maxrectspacker$rect.score1 = k;
                    maxrectspacker$rect.score2 = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.rotated = true;
                }
            }
        }

        return maxrectspacker$rect;
    }

    private MaxRectsPacker.Rect findPositionForNewNodeBestShortSideFit(int width, int height, int rotatedWidth, int rotatedHeight, boolean rotate)
    {
        MaxRectsPacker.Rect maxrectspacker$rect = new MaxRectsPacker.Rect();
        maxrectspacker$rect.score1 = Integer.MAX_VALUE;

        for (int i = 0; i < this.freeRectangles.size; ++i)
        {
            if (((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width >= width && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height >= height)
            {
                int j = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width - width);
                int k = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height - height);
                int l = Math.min(j, k);
                int i1 = Math.max(j, k);

                if (l < maxrectspacker$rect.score1 || l == maxrectspacker$rect.score1 && i1 < maxrectspacker$rect.score2)
                {
                    maxrectspacker$rect.x = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.y = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y;
                    maxrectspacker$rect.width = width;
                    maxrectspacker$rect.height = height;
                    maxrectspacker$rect.score1 = l;
                    maxrectspacker$rect.score2 = i1;
                    maxrectspacker$rect.rotated = false;
                }
            }

            if (rotate && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width >= rotatedWidth && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height >= rotatedHeight)
            {
                int j1 = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width - rotatedWidth);
                int k1 = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height - rotatedHeight);
                int l1 = Math.min(j1, k1);
                int i2 = Math.max(j1, k1);

                if (l1 < maxrectspacker$rect.score1 || l1 == maxrectspacker$rect.score1 && i2 < maxrectspacker$rect.score2)
                {
                    maxrectspacker$rect.x = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.y = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y;
                    maxrectspacker$rect.width = rotatedWidth;
                    maxrectspacker$rect.height = rotatedHeight;
                    maxrectspacker$rect.score1 = l1;
                    maxrectspacker$rect.score2 = i2;
                    maxrectspacker$rect.rotated = true;
                }
            }
        }

        return maxrectspacker$rect;
    }

    private MaxRectsPacker.Rect findPositionForNewNodeBestLongSideFit(int width, int height, int rotatedWidth, int rotatedHeight, boolean rotate)
    {
        MaxRectsPacker.Rect maxrectspacker$rect = new MaxRectsPacker.Rect();
        maxrectspacker$rect.score2 = Integer.MAX_VALUE;

        for (int i = 0; i < this.freeRectangles.size; ++i)
        {
            if (((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width >= width && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height >= height)
            {
                int j = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width - width);
                int k = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height - height);
                int l = Math.min(j, k);
                int i1 = Math.max(j, k);

                if (i1 < maxrectspacker$rect.score2 || i1 == maxrectspacker$rect.score2 && l < maxrectspacker$rect.score1)
                {
                    maxrectspacker$rect.x = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.y = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y;
                    maxrectspacker$rect.width = width;
                    maxrectspacker$rect.height = height;
                    maxrectspacker$rect.score1 = l;
                    maxrectspacker$rect.score2 = i1;
                    maxrectspacker$rect.rotated = false;
                }
            }

            if (rotate && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width >= rotatedWidth && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height >= rotatedHeight)
            {
                int j1 = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width - rotatedWidth);
                int k1 = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height - rotatedHeight);
                int l1 = Math.min(j1, k1);
                int i2 = Math.max(j1, k1);

                if (i2 < maxrectspacker$rect.score2 || i2 == maxrectspacker$rect.score2 && l1 < maxrectspacker$rect.score1)
                {
                    maxrectspacker$rect.x = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.y = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y;
                    maxrectspacker$rect.width = rotatedWidth;
                    maxrectspacker$rect.height = rotatedHeight;
                    maxrectspacker$rect.score1 = l1;
                    maxrectspacker$rect.score2 = i2;
                    maxrectspacker$rect.rotated = true;
                }
            }
        }

        return maxrectspacker$rect;
    }

    private MaxRectsPacker.Rect findPositionForNewNodeBestAreaFit(int width, int height, int rotatedWidth, int rotatedHeight, boolean rotate)
    {
        MaxRectsPacker.Rect maxrectspacker$rect = new MaxRectsPacker.Rect();
        maxrectspacker$rect.score1 = Integer.MAX_VALUE;

        for (int i = 0; i < this.freeRectangles.size; ++i)
        {
            int j = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width * ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height - width * height;

            if (((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width >= width && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height >= height)
            {
                int k = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width - width);
                int l = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height - height);
                int i1 = Math.min(k, l);

                if (j < maxrectspacker$rect.score1 || j == maxrectspacker$rect.score1 && i1 < maxrectspacker$rect.score2)
                {
                    maxrectspacker$rect.x = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.y = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y;
                    maxrectspacker$rect.width = width;
                    maxrectspacker$rect.height = height;
                    maxrectspacker$rect.score2 = i1;
                    maxrectspacker$rect.score1 = j;
                    maxrectspacker$rect.rotated = false;
                }
            }

            if (rotate && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width >= rotatedWidth && ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height >= rotatedHeight)
            {
                int j1 = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).width - rotatedWidth);
                int k1 = Math.abs(((MaxRectsPacker.Rect)this.freeRectangles.get(i)).height - rotatedHeight);
                int l1 = Math.min(j1, k1);

                if (j < maxrectspacker$rect.score1 || j == maxrectspacker$rect.score1 && l1 < maxrectspacker$rect.score2)
                {
                    maxrectspacker$rect.x = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).x;
                    maxrectspacker$rect.y = ((MaxRectsPacker.Rect)this.freeRectangles.get(i)).y;
                    maxrectspacker$rect.width = rotatedWidth;
                    maxrectspacker$rect.height = rotatedHeight;
                    maxrectspacker$rect.score2 = l1;
                    maxrectspacker$rect.score1 = j;
                    maxrectspacker$rect.rotated = true;
                }
            }
        }

        return maxrectspacker$rect;
    }

    private int commonIntervalLength(int i1start, int i1end, int i2start, int i2end)
    {
        return i1end >= i2start && i2end >= i1start ? Math.min(i1end, i2end) - Math.max(i1start, i2start) : 0;
    }

    private int contactPointScoreNode(int x, int y, int width, int height)
    {
        int i = 0;

        if (x == 0 || x + width == this.binWidth)
        {
            i += height;
        }

        if (y == 0 || y + height == this.binHeight)
        {
            i += width;
        }

        GdxArray<MaxRectsPacker.Rect> gdxarray = this.usedRectangles;
        int j = 0;

        for (int k = gdxarray.size; j < k; ++j)
        {
            MaxRectsPacker.Rect maxrectspacker$rect = (MaxRectsPacker.Rect)gdxarray.get(j);

            if (maxrectspacker$rect.x == x + width || maxrectspacker$rect.x + maxrectspacker$rect.width == x)
            {
                i += this.commonIntervalLength(maxrectspacker$rect.y, maxrectspacker$rect.y + maxrectspacker$rect.height, y, y + height);
            }

            if (maxrectspacker$rect.y == y + height || maxrectspacker$rect.y + maxrectspacker$rect.height == y)
            {
                i += this.commonIntervalLength(maxrectspacker$rect.x, maxrectspacker$rect.x + maxrectspacker$rect.width, x, x + width);
            }
        }

        return i;
    }

    private MaxRectsPacker.Rect findPositionForNewNodeContactPoint(int width, int height, int rotatedWidth, int rotatedHeight, boolean rotate)
    {
        MaxRectsPacker.Rect maxrectspacker$rect = new MaxRectsPacker.Rect();
        maxrectspacker$rect.score1 = -1;
        GdxArray<MaxRectsPacker.Rect> gdxarray = this.freeRectangles;
        int i = 0;

        for (int j = gdxarray.size; i < j; ++i)
        {
            MaxRectsPacker.Rect maxrectspacker$rect1 = (MaxRectsPacker.Rect)gdxarray.get(i);

            if (maxrectspacker$rect1.width >= width && maxrectspacker$rect1.height >= height)
            {
                int k = this.contactPointScoreNode(maxrectspacker$rect1.x, maxrectspacker$rect1.y, width, height);

                if (k > maxrectspacker$rect.score1)
                {
                    maxrectspacker$rect.x = maxrectspacker$rect1.x;
                    maxrectspacker$rect.y = maxrectspacker$rect1.y;
                    maxrectspacker$rect.width = width;
                    maxrectspacker$rect.height = height;
                    maxrectspacker$rect.score1 = k;
                    maxrectspacker$rect.rotated = false;
                }
            }

            if (rotate && maxrectspacker$rect1.width >= rotatedWidth && maxrectspacker$rect1.height >= rotatedHeight)
            {
                int l = this.contactPointScoreNode(maxrectspacker$rect1.x, maxrectspacker$rect1.y, rotatedWidth, rotatedHeight);

                if (l > maxrectspacker$rect.score1)
                {
                    maxrectspacker$rect.x = maxrectspacker$rect1.x;
                    maxrectspacker$rect.y = maxrectspacker$rect1.y;
                    maxrectspacker$rect.width = rotatedWidth;
                    maxrectspacker$rect.height = rotatedHeight;
                    maxrectspacker$rect.score1 = l;
                    maxrectspacker$rect.rotated = true;
                }
            }
        }

        return maxrectspacker$rect;
    }

    private boolean splitFreeNode(MaxRectsPacker.Rect freeNode, MaxRectsPacker.Rect usedNode)
    {
        if (usedNode.x < freeNode.x + freeNode.width && usedNode.x + usedNode.width > freeNode.x && usedNode.y < freeNode.y + freeNode.height && usedNode.y + usedNode.height > freeNode.y)
        {
            if (usedNode.x < freeNode.x + freeNode.width && usedNode.x + usedNode.width > freeNode.x)
            {
                if (usedNode.y > freeNode.y && usedNode.y < freeNode.y + freeNode.height)
                {
                    MaxRectsPacker.Rect maxrectspacker$rect = new MaxRectsPacker.Rect(freeNode);
                    maxrectspacker$rect.height = usedNode.y - maxrectspacker$rect.y;
                    this.freeRectangles.add(maxrectspacker$rect);
                }

                if (usedNode.y + usedNode.height < freeNode.y + freeNode.height)
                {
                    MaxRectsPacker.Rect maxrectspacker$rect1 = new MaxRectsPacker.Rect(freeNode);
                    maxrectspacker$rect1.y = usedNode.y + usedNode.height;
                    maxrectspacker$rect1.height = freeNode.y + freeNode.height - (usedNode.y + usedNode.height);
                    this.freeRectangles.add(maxrectspacker$rect1);
                }
            }

            if (usedNode.y < freeNode.y + freeNode.height && usedNode.y + usedNode.height > freeNode.y)
            {
                if (usedNode.x > freeNode.x && usedNode.x < freeNode.x + freeNode.width)
                {
                    MaxRectsPacker.Rect maxrectspacker$rect2 = new MaxRectsPacker.Rect(freeNode);
                    maxrectspacker$rect2.width = usedNode.x - maxrectspacker$rect2.x;
                    this.freeRectangles.add(maxrectspacker$rect2);
                }

                if (usedNode.x + usedNode.width < freeNode.x + freeNode.width)
                {
                    MaxRectsPacker.Rect maxrectspacker$rect3 = new MaxRectsPacker.Rect(freeNode);
                    maxrectspacker$rect3.x = usedNode.x + usedNode.width;
                    maxrectspacker$rect3.width = freeNode.x + freeNode.width - (usedNode.x + usedNode.width);
                    this.freeRectangles.add(maxrectspacker$rect3);
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    private void pruneFreeList()
    {
        GdxArray<MaxRectsPacker.Rect> gdxarray = this.freeRectangles;
        int i = 0;

        for (int j = gdxarray.size; i < j; ++i)
        {
            for (int k = i + 1; k < j; ++k)
            {
                MaxRectsPacker.Rect maxrectspacker$rect = (MaxRectsPacker.Rect)gdxarray.get(i);
                MaxRectsPacker.Rect maxrectspacker$rect1 = (MaxRectsPacker.Rect)gdxarray.get(k);

                if (this.isContainedIn(maxrectspacker$rect, maxrectspacker$rect1))
                {
                    gdxarray.removeIndex(i);
                    --i;
                    --j;
                    break;
                }

                if (this.isContainedIn(maxrectspacker$rect1, maxrectspacker$rect))
                {
                    gdxarray.removeIndex(k);
                    --k;
                    --j;
                }
            }
        }
    }

    private boolean isContainedIn(MaxRectsPacker.Rect a, MaxRectsPacker.Rect b)
    {
        return a.x >= b.x && a.y >= b.y && a.x + a.width <= b.x + b.width && a.y + a.height <= b.y + b.height;
    }

    public static enum FreeRectChoiceHeuristic
    {
        BestShortSideFit,
        BestLongSideFit,
        BestAreaFit,
        BottomLeftRule,
        ContactPointRule;
    }

    public static class Page
    {
        public GdxArray<MaxRectsPacker.Rect> outputRects;
        public GdxArray<MaxRectsPacker.Rect> remainingRects;
        public float occupancy;
        public int x;
        public int y;
        public int width;
        public int height;
    }

    public static class Rect implements Comparable<MaxRectsPacker.Rect>
    {
        public String name;
        public int x;
        public int y;
        public int width;
        public int height;
        public boolean rotated;
        public boolean canRotate = true;
        int score1;
        int score2;

        public Rect(int width, int height)
        {
            this.width = width;
            this.height = height;
        }

        Rect()
        {
        }

        Rect(MaxRectsPacker.Rect rect)
        {
            this.x = rect.x;
            this.y = rect.y;
            this.width = rect.width;
            this.height = rect.height;
        }

        void set(MaxRectsPacker.Rect rect)
        {
            this.name = rect.name;
            this.x = rect.x;
            this.y = rect.y;
            this.width = rect.width;
            this.height = rect.height;
            this.rotated = rect.rotated;
            this.canRotate = rect.canRotate;
            this.score1 = rect.score1;
            this.score2 = rect.score2;
        }

        public int compareTo(MaxRectsPacker.Rect o)
        {
            return this.name.compareTo(o.name);
        }

        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            else if (obj == null)
            {
                return false;
            }
            else if (this.getClass() != obj.getClass())
            {
                return false;
            }
            else
            {
                MaxRectsPacker.Rect maxrectspacker$rect = (MaxRectsPacker.Rect)obj;

                if (this.name == null)
                {
                    if (maxrectspacker$rect.name != null)
                    {
                        return false;
                    }
                }
                else if (!this.name.equals(maxrectspacker$rect.name))
                {
                    return false;
                }

                return true;
            }
        }

        public String toString()
        {
            return this.name + "[" + this.x + "," + this.y + " " + this.width + "x" + this.height + "]";
        }
    }
}
