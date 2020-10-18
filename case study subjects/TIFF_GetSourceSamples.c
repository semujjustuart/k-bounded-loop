/************************************************************************/
/*                       TIFF_GetSourceSamples()                        */
/************************************************************************/

static void 
TIFF_GetSourceSamples( double * padfSamples, unsigned char *pabySrc, 
                       int nPixelBytes, int nSampleFormat, 
                       int nXSize, int nYSize, 
                       int nPixelOffset, int nLineOffset )
{
    int  iXOff, iYOff, iSample;

    iSample = 0;

    for( iYOff = 0; iYOff < nYSize; iYOff++ )
    {
        for( iXOff = 0; iXOff < nXSize; iXOff++ )
        {
            unsigned char *pabyData;

            pabyData = pabySrc + iYOff * nLineOffset + iXOff * nPixelOffset;

            if( nSampleFormat == SAMPLEFORMAT_UINT && nPixelBytes == 1 )
            {
                padfSamples[iSample++] = *pabyData;
            }
            else if( nSampleFormat == SAMPLEFORMAT_UINT && nPixelBytes == 2 )
            {
                padfSamples[iSample++] = ((uint16 *) pabyData)[0];
            }
            else if( nSampleFormat == SAMPLEFORMAT_UINT && nPixelBytes == 4 )
            {
                padfSamples[iSample++] = ((uint32 *) pabyData)[0];
            }
            else if( nSampleFormat == SAMPLEFORMAT_INT && nPixelBytes == 2 )
            {
                padfSamples[iSample++] = ((int16 *) pabyData)[0];
            }
            else if( nSampleFormat == SAMPLEFORMAT_INT && nPixelBytes == 32 )
            {
                padfSamples[iSample++] = ((int32 *) pabyData)[0];
            }
            else if( nSampleFormat == SAMPLEFORMAT_IEEEFP && nPixelBytes == 4 )
            {
                padfSamples[iSample++] = ((float *) pabyData)[0];
            }
            else if( nSampleFormat == SAMPLEFORMAT_IEEEFP && nPixelBytes == 8 )
            {
                padfSamples[iSample++] = ((double *) pabyData)[0];
            }
        }
    }
} 
