//
//  WidgetOneViewManager.h
//  NativeComp
//
//  Created by adrian.hartanto on 26/11/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <React/RCTViewManager.h>

NS_ASSUME_NONNULL_BEGIN

@interface WidgetOneViewManager : RCTViewManager

- (void)setSizeForView:(UIView *)view size:(CGSize)size;

@end

NS_ASSUME_NONNULL_END
